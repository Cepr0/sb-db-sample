package com.example.demo.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.springframework.context.annotation.FilterType.ASPECTJ;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = ASPECTJ, pattern = "**.controller.async.*")
)
public class ControllerConfig {
    @Profile("async")
    @Configuration
    @ComponentScan(
            excludeFilters = @ComponentScan.Filter(type = ASPECTJ, pattern = "**.controller.sync.*"),
            includeFilters = @ComponentScan.Filter(type = ASPECTJ, pattern = "**.controller.async.*")
    )
    static class AsyncControllerConfig {
    }
}
