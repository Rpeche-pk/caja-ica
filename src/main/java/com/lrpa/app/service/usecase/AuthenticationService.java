package com.lrpa.app.service.usecase;

import com.lrpa.app.controller.dto.request.AuthenticationRequest;
import com.lrpa.app.controller.dto.response.AuthenticationResponse;

/**
 * @author ROMULO
 * @package com.lrpa.app.service.usecase
 * @license Lrpa, zephyr cygnus
 * @since 29/2/2024
 */
public interface AuthenticationService {

    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}
