package com.example.demo.app.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Validated
@ConfigurationProperties("demo.api")
public class ApiProps {

    /**
     * API type - either synchronous (blocked) or asynchronous (non-blocked).
     */
    @NotNull private ApiType type;

    public enum ApiType {
        /**
         * Synchronous (blocked) API
         */
        sync,

        /**
         * Asynchronous (non-blocked) API
         */
        async
    }
}
