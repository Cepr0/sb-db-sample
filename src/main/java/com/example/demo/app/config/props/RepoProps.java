package com.example.demo.app.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Validated
@ConfigurationProperties("demo.repo")
public class RepoProps {

    /**
     * Database repo type.
     */
    @NotNull private RepoType type;

    public enum RepoType {
        /**
         * JPA repositories
         */
        jpa,

        /**
         * MongoDB repositories
         */
        mongo
    }
}
