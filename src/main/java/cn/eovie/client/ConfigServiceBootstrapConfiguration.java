package cn.eovie.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by earayu on 2017/11/14.
 */
@Configuration
public class ConfigServiceBootstrapConfiguration {

    @Bean
    @ConditionalOnMissingBean({ConfigServicePropertySourceLocator.class})
    @ConditionalOnProperty(
            value = {"spring.cloud.config.enabled"},
            matchIfMissing = true
    )
    public ConfigServicePropertySourceLocator configServicePropertySource(ConfigClientProperties properties) {
        ConfigServicePropertySourceLocator locator = new ConfigServicePropertySourceLocator(properties);
        return locator;
    }

}
