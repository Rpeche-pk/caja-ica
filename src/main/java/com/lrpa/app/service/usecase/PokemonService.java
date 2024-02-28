package com.lrpa.app.service.usecase;

import com.lrpa.app.controller.dto.request.PageableDto;
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
    PokeResponseDto createPokemon(PokeRequestDto requestDto);
    PokeResponseDto updatePokemon(PokeRequestDto requestDto, Long id);
    void deletePokemon(Long id);
    ResponseDto findByNamePokemon(String name);
    List<ResponseDto> getAllPokemons(Pageable pageable);
}
