package com.lrpa.app.service.impl;

import com.lrpa.app.controller.dto.request.PokeRequestDto;
import com.lrpa.app.controller.dto.response.PokeResponseDto;
import com.lrpa.app.controller.dto.response.ResponseDto;
import com.lrpa.app.persistance.entity.PokemonEntity;
import com.lrpa.app.persistance.mapper.PokemonMapper;
import com.lrpa.app.persistance.repository.PokemonRepository;
import com.lrpa.app.service.usecase.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ROMULO
 * @package com.lrpa.app.service.impl
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@Service
@RequiredArgsConstructor
public class PokemonImpl implements PokemonService {

    private final PokemonRepository repository;
    private final PokemonMapper mapper;

    @Override
    public PokeResponseDto createPokemon(PokeRequestDto requestDto) {
        return null;
    }

    @Override
    public PokeResponseDto updatePokemon(PokeRequestDto requestDto, Long id) {
        return null;
    }

    @Override
    public void deletePokemon(Long id) {

    }

    @Override
    public ResponseDto findByNamePokemon(String name) {


        return null;
    }

    @Override
    public List<ResponseDto> getAllPokemons(Pageable pageable) {
        Page<PokemonEntity> all = repository.findAll(pageable);
        return all.getContent()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }
}
