package com.swap.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringDocConfig {

    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Swap Translator")
                                .version("v1")
                                .description("Swap Translator REST API documentation.")
                )
                .tags(
                        Arrays.asList(
                                new Tag().name("Translate").description("Translate text route")
                        )
                );
    }
}
