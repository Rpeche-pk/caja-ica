package com.lrpa.app.service.usecase;

import com.lrpa.app.controller.dto.request.PokeRequestDto;
import com.lrpa.app.controller.dto.response.PokeResponseDto;
import com.lrpa.app.controller.dto.response.ResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author ROMULO
 * @package com.lrpa.app.service.usecase
 * @license Lrpa, zephyr cygnus
 * @since 27/2/2024
 */
public interface PokemonService {
    /**
     * create a new pokemon
     *
     * @param requestDto
     * @return PokeResponseDto
     */
    PokeResponseDto createPokemon(PokeRequestDto requestDto);

    /**
     * update a pokemon
     *
     * @param requestDto
     * @param id
     * @return PokeResponseDto
     */
    PokeResponseDto updatePokemon(PokeRequestDto requestDto, Long id);

    /**
     * delete a pokemon
     *
     * @param id
     */
    void deletePokemon(Long id);

    /**
     * find a pokemon by name
     *
     * @param name
     * @return ResponseDto
     */
    ResponseDto findByNamePokemon(String name);

    /**
     * get all pokemons
     *
     * @param pageable
     * @return List<ResponseDto>
     */
    List<ResponseDto> getAllPokemons(Pageable pageable);
}
