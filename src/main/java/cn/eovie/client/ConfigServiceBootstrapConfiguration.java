package cn.eovie.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by earayu on 2017/11/14.
 */
@Configuration
public class ConfigServiceBootstrapConfiguration {

    @Autowired
    private ConfigClientProperties properties;

    @Bean
    @ConditionalOnMissingBean({ConfigServicePropertySourceLocator.class})
    @ConditionalOnProperty(
            value = {"spring.cloud.config.enabled"},
            matchIfMissing = true
    )
    public ConfigServicePropertySourceLocator configServicePropertySource() {
        ConfigServicePropertySourceLocator locator = new ConfigServicePropertySourceLocator(properties);
        return locator;
    }

}
