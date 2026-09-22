package com.example.learning.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record AppProperties(String welcomeMessage, String maxPageSize) {
}

//app.welcome-message , app.max-page-size
