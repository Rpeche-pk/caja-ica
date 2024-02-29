package com.lrpa.app.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ROMULO
 * @package com.lrpa.app.controller.dto.response
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@Getter
@AllArgsConstructor
public class AuthenticationResponse {
    private String jwt;
}
