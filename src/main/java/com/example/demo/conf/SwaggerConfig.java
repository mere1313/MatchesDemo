package com.example.demo.conf;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Match Management REST API")
                        .version("1.0")
                        .description("This API provides endpoints to manage sports matches and their odds."))
                .tags(List.of(
                        new Tag().name("Matches").description("Operations related to sports matches."),
                        new Tag().name("Match Odds").description("Operations related to match odds."))
                );
    }
}
