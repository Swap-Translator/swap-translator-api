package com.swap.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Swap Translator")
                                .version("v1")
                                .description("Swap Translator REST API documentation.")

                );
    }
}
