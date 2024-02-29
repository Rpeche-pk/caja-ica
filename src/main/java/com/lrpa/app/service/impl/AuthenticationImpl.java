package com.lrpa.app.service.impl;

import com.lrpa.app.controller.dto.request.AuthenticationRequest;
import com.lrpa.app.controller.dto.response.AuthenticationResponse;
import com.lrpa.app.persistance.entity.UserEntity;
import com.lrpa.app.persistance.repository.UserRepository;
import com.lrpa.app.security.jwt.JwtTokenProvider;
import com.lrpa.app.service.usecase.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 * @author ROMULO
 * @package com.lrpa.app.service.impl
 * @license Lrpa, zephyr cygnus
 * @since 29/2/2024
 */
@Service
@RequiredArgsConstructor
public class AuthenticationImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtService;

    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserEntity user = userRepository.findByUsername(authenticationRequest.getUsername()).get();

        String jwt = jwtService.generateToken(user);
        return new AuthenticationResponse(jwt);
    }
}
