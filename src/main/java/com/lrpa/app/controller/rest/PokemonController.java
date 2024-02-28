package com.lrpa.app.controller.rest;

import com.lrpa.app.controller.dto.request.PageableDto;
import com.lrpa.app.controller.dto.response.ResponseDto;
import com.lrpa.app.service.usecase.PokemonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.lrpa.app.util.Constants.API_POKEMON;

/**
 * @author ROMULO
 * @package com.lrpa.app.controller.rest
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@RestController
@RequestMapping(API_POKEMON)
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService service;

    @GetMapping
    public ResponseEntity<?> getAllPokemons(@PageableDefault(page = 0, size = 15) @ParameterObject Pageable pageable) {
        List<ResponseDto> allPokemons = service.getAllPokemons(pageable);
        return new ResponseEntity<>(allPokemons, HttpStatus.OK);
    }


}
