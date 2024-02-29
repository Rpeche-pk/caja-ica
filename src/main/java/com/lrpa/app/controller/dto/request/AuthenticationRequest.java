package com.lrpa.app.controller.dto.request;

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

    @NotBlank(message = "Username is required")
    private String username;
    private String password;
}
