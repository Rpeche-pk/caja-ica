package com.lrpa.app.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ROMULO
 * @package com.lrpa.app.controller.dto.request
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "Username", example = "your username")
    @NotBlank(message = "Username is required")
    private String username;
    @Schema(description = "Password", example = "your password - numeric and alphanumeric characters")
    private String password;
}
