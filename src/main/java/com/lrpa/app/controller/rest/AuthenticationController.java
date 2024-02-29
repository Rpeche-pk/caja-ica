package com.lrpa.app.controller.rest;

import com.lrpa.app.controller.dto.request.AuthenticationRequest;
import com.lrpa.app.service.usecase.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.lrpa.app.util.Constants.API_AUTH;
import static com.lrpa.app.util.Constants.API_LOGIN;

/**
 * @author ROMULO
 * @package com.lrpa.app.controller.rest
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@RestController
@RequestMapping(API_AUTH)
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication Controller")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping(API_LOGIN)
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(service.login(authenticationRequest));
    }
}
