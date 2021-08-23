package com.example.aircompany.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI airOpenApi() {
        return new OpenAPI()
                .info(
                        new Info().title("Api заказа билетов")
                                .version("1")
                                .description("Описание для Api заказа билетов")
                );
    }
}
