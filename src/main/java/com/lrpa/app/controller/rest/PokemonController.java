package com.lrpa.app.controller.rest;

import com.lrpa.app.controller.dto.request.PokeRequestDto;
import com.lrpa.app.controller.dto.response.PokeResponseDto;
import com.lrpa.app.controller.dto.response.ResponseDto;
import com.lrpa.app.exception.GenericException;
import com.lrpa.app.service.usecase.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lrpa.app.util.Constants.*;

/**
 * @author ROMULO
 * @package com.lrpa.app.controller.rest
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@RestController
@RequestMapping(API_POKEMON)
@RequiredArgsConstructor
@Tag(name = "Pokemon", description = "Pokemon Controller")
public class PokemonController {

    private final PokemonService service;

    @Operation(
            summary = "Get all pokemons",
            description = "Get all pokemons",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ok",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ResponseDto.class))
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = {
                                    @Content(mediaType = "application/json")
                            }
                    )
            }
    )
    @GetMapping
    public ResponseEntity<?> getAllPokemons(@PageableDefault(page = 0, size = 15) @Schema(example = "sort -> weight,asc|desc") @ParameterObject Pageable pageable) {
        List<ResponseDto> allPokemons = service.getAllPokemons(pageable);
        return new ResponseEntity<>(allPokemons, HttpStatus.OK);
    }

    @Operation(
            summary = "Get pokemon by name",
            description = "Get pokemon by name",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ok",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ResponseDto.class))
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ProblemDetail.class))
                            }
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ProblemDetail.class))
                            }
                    )
            }
    )
    @GetMapping(API_POKEMON_NAME)
    public ResponseEntity<?> findByNamePokemon(@PathVariable @Schema(description = "name pokemon", defaultValue = "Pikachu") String name) {
        ResponseDto byNamePokemon = service.findByNamePokemon(name);
        return new ResponseEntity<>(byNamePokemon, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete pokemon",
            description = "Delete pokemon",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "No content",
                            content = {
                                    @Content(mediaType = "application/json")
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = {
                                    @Content(mediaType = "application/json")
                            }
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = {
                                    @Content(mediaType = "application/json")
                            }
                    )
            }
    )
    @DeleteMapping(API_POKEMON_ID)
    public ResponseEntity<?> deletePokemon(@PathVariable @Schema(defaultValue = "1", description = "id range [1-24]") Long id) {
        service.deletePokemon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Update pokemon",
            description = "Update pokemon",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ok",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = PokeResponseDto.class))
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ProblemDetail.class))
                            }
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ProblemDetail.class))
                            }
                    )
            }
    )
    @PutMapping(API_POKEMON_ID)
    public ResponseEntity<?> updatePokemon(@RequestBody @Valid PokeRequestDto requestDto, @Schema(example = "[1 - 24]", defaultValue = "2") @PathVariable Long id) {
        PokeResponseDto pokeResponseDto = service.updatePokemon(requestDto, id);
        return new ResponseEntity<>(pokeResponseDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Create pokemon",
            description = "Create pokemon",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = PokeResponseDto.class))
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = GenericException.class))
                            }
                    )
            }
    )
    @PostMapping("/")
    public ResponseEntity<?> createPokemon(@RequestBody @Valid PokeRequestDto requestDto) {
        PokeResponseDto pokeResponseDto = service.createPokemon(requestDto);
        return new ResponseEntity<>(pokeResponseDto, HttpStatus.CREATED);
    }


}
