package com.jfouad.spring.corsspringbootstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "spring.cors")
public class CorsProperties {
    List<String> allowedOrigins;
    List<String> apiPaths;

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public List<String> getApiPaths() {
        return apiPaths;
    }

    public void setApiPaths(List<String> apiPaths) {
        this.apiPaths = apiPaths;
    }
}
