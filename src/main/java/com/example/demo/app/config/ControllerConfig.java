package com.example.demo.app.config;

import com.example.demo.app.config.props.ApiProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(ApiProps.class)
@Slf4j
@Configuration
public class ControllerConfig {

    @Slf4j
    @Configuration
    @ConditionalOnProperty(name = "demo.api.type", havingValue = "async")
    @ComponentScan("com.example.demo.impl.controller.async")
    static class AsyncControllerConfig {
        public AsyncControllerConfig(ApiProps props) {
            log.debug("[d] API type is {}", props.getType());
        }
    }

    @EnableConfigurationProperties(ApiProps.class)
    @Slf4j
    @Configuration
    @ConditionalOnProperty(name = "demo.api.type", havingValue = "sync")
    @ComponentScan("com.example.demo.impl.controller.sync")
    static class SyncControllerConfig {
        public SyncControllerConfig(ApiProps props) {
            log.debug("[d] API type is {}", props.getType());
        }
    }
}
