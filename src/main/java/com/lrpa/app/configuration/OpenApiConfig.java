package com.lrpa.app.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
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
                @Server(url = "http://149.50.137.89:9896/", description = "Production server"),
                @Server(url = "http://localhost:9896/", description = "Local server")
        }
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        description = "Enter JWT Bearer token",
        in = SecuritySchemeIn.HEADER
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
