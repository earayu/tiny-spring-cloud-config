package cn.eovie.client;

import cn.eovie.environment.EnvironmentDTO;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * org.springframework.cloud.bootstrap.config.PropertySourceLocator
 * 在spring cloud 应用启动环节会从容器中获取这个类，然后用它加载配置文件
 * Created by earayu on 2017/11/14.
 */
public class ConfigServicePropertySourceLocator implements PropertySourceLocator {

    private ConfigClientProperties properties;

    private RestTemplate restTemplate;

    public ConfigServicePropertySourceLocator(ConfigClientProperties properties) {
        this.properties = properties;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public PropertySource<?> locate(Environment environment) {
        EnvironmentDTO environmentDTO = getRemoteEnvironment();
        //暂时只支持一个profile
        Map<String, Object> map = (Map<String, Object>) environmentDTO.getPropertySources().get(0).getSource();
        PropertySource propertySource = new MapPropertySource(properties.getName(), map);
        return propertySource;
    }

    private EnvironmentDTO getRemoteEnvironment(){
        String path = StringUtils.hasText(properties.getLabel())? "/{name}/{profile}/{label}": "/{name}/{profile}";
        Object[] args = StringUtils.hasText(properties.getLabel())?
                new Object[]{properties.getName(), properties.getProfile(), properties.getLabel()} :
                new Object[]{properties.getName(), properties.getProfile()};

        final HttpEntity<Void> entity = new HttpEntity<>(null, new HttpHeaders());
        ResponseEntity<EnvironmentDTO> response = restTemplate.exchange(
                properties.getUri() + path,
                HttpMethod.GET,
                new HttpEntity<>(null, new HttpHeaders()),
                EnvironmentDTO.class,
                args
        );
        if (response == null || response.getStatusCode() != HttpStatus.OK) {
            return null;
        }
        EnvironmentDTO result = response.getBody();
        return result;
    }



}
