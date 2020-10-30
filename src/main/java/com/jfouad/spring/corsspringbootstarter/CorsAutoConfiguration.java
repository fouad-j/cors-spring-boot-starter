package com.jfouad.spring.corsspringbootstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(CorsProperties.class)
@ConditionalOnProperty(prefix = "spring.cors", name = "enabled", havingValue = "true")
public class CorsAutoConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public CorsFilter corsConfiguration(CorsProperties properties) {
        CustomCorsConfiguration customCorsConfiguration = new CustomCorsConfiguration();

        customCorsConfiguration.setAllowedOriginRegex(properties.getAllowedOrigins());
        customCorsConfiguration.applyPermitDefaultValues();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        for (String apiPath : properties.apiPaths) {
            source.registerCorsConfiguration(apiPath, customCorsConfiguration);
        }

        return new CorsFilter(source);
    }
}
