package com.lrpa.app.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ROMULO
 * @package com.lrpa.app.configuration
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@Configuration
@OpenAPIDefinition(
        servers = {
                @Server(url = "http://localhost:9698/", description = "Local server"),
                @Server(url = "https://lrpa-pokemon-api.herokuapp.com", description = "Production server")
        }
)
public class OpenApiConfig {

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .info(new Info()
                                .title("Pokemon API")
                                .version("1.0")
                                .description("Documentation Pokemon API v1.0")
                                .termsOfService("http://swagger.io/terms/")
                                .license(new License()
                                        .name("Apache 2.0")
                                        .url("http://springdoc.org"))
                                .contact(new Contact()
                                        .name("Lrpa")
                                        .url("https://backend.luispeche.me"))
                        );
        }
}
