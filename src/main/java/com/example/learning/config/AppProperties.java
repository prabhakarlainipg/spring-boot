package com.example.learning.config;

import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "app")
public record AppProperties(String welcomeMessage, @Min(1) int maxPageSize) {
}

//app.welcome-message , app.max-page-size
