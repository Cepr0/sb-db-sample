package com.example.demo.app.config;

import com.example.demo.app.config.props.RepoProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableConfigurationProperties(RepoProps.class)
@Configuration
public class RepoConfig {
    @Slf4j
    @Configuration
    @ConditionalOnProperty(name = "demo.repo.type", havingValue = "jpa")
    @EnableJpaRepositories("com.example.demo.impl.repo")
    static class JpaRepoConfig {
        public JpaRepoConfig(RepoProps props) {
            log.debug("[d] Repo type is {}", props.getType());
        }
    }
}
