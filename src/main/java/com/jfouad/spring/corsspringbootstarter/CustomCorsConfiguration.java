package com.jfouad.spring.corsspringbootstarter;

import org.springframework.lang.NonNull;
import org.springframework.web.cors.CorsConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomCorsConfiguration extends CorsConfiguration {

    private List<Pattern> allowedOrigins = new ArrayList<>();

    @Override
    public String checkOrigin(String requestOrigin) {

        for (Pattern allowedOrigin : this.allowedOrigins) {
            if (allowedOrigin.matcher(requestOrigin).matches()) {
                return requestOrigin;
            }
        }

        return null;
    }

    public void setAllowedOriginRegex(@NonNull List<String> allowedOriginsRegex) {
        this.allowedOrigins = allowedOriginsRegex
                .stream()
                .map(allowedOrigin -> allowedOrigin.replace(".", "\\."))
                .map(allowedOrigin -> allowedOrigin.replace("*", ".*"))
                .map(Pattern::compile)
                .collect(Collectors.toList());
    }
}
