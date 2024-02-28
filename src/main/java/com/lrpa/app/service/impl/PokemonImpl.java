package com.lrpa.app.service.impl;

import com.lrpa.app.controller.dto.request.PokeRequestDto;
import com.lrpa.app.controller.dto.response.PokeResponseDto;
import com.lrpa.app.controller.dto.response.ResponseDto;
import com.lrpa.app.exception.GenericException;
import com.lrpa.app.exception.ResourceNotFoundException;
import com.lrpa.app.persistance.entity.PokemonEntity;
import com.lrpa.app.persistance.mapper.PokemonMapper;
import com.lrpa.app.persistance.repository.PokemonRepository;
import com.lrpa.app.service.usecase.PokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.LongPredicate;

/**
 * @author ROMULO
 * @package com.lrpa.app.service.impl
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonImpl implements PokemonService {

    private final PokemonRepository repository;
    private final PokemonMapper mapper;

    @Override
    @Transactional
    public PokeResponseDto createPokemon(PokeRequestDto requestDto) {
        try {
            Optional<PokemonEntity> entity = repository.findByNamePokemon(requestDto.getName());
            if (entity.isPresent()) throw new GenericException("Pokemon already exists");
            PokemonEntity save = repository.save(mapper.toPokemonEntity(requestDto));
            return PokeResponseDto.builder()
                    .message("Pokemon Created")
                    .status(HttpStatus.CREATED.value())
                    .name(save.getName())
                    .build();
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return PokeResponseDto.builder()
                    .message("Error creating pokemon")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
        }

    }

    @Override
    @Transactional
    @Modifying
    public PokeResponseDto updatePokemon(PokeRequestDto requestDto, Long id) {
        try {
            Optional<PokemonEntity> pokemonEntity = repository.findById(id);

            if (pokemonEntity.isEmpty()) throw new ResourceNotFoundException("Pokemon not found");

            PokemonEntity entity = pokemonEntity.get().updatePokemon(requestDto);

            PokemonEntity save = repository.save(entity);
            return PokeResponseDto.builder()
                    .message("Pokemon updated")
                    .status(HttpStatus.OK.value())
                    .name(save.getName())
                    .build();
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return PokeResponseDto.builder()
                    .message("Error updating pokemon")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
        }

    }

    @Override
    @Transactional
    public void deletePokemon(Long id) {

        LongPredicate isNull = Objects::isNull;

        if (isNull.test(id)) throw new GenericException("Id is required");

        Optional<PokemonEntity> pokemon = repository.findById(id);

        if (pokemon.isEmpty()) throw new ResourceNotFoundException("Pokemon not found or already deleted");

        pokemon.get().setEnabled(false);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDto findByNamePokemon(String name) {

        if (name.isBlank()) throw new GenericException("Name is required");

        return repository.findByNamePokemon(name)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("Pokemon not found"));

    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseDto> getAllPokemons(Pageable pageable) {
        try {
            Page<PokemonEntity> all = repository.findAll(pageable);
            return all.getContent()
                    .stream()
                    .map(mapper::toResponseDto)
                    .toList();
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return List.of();
        }

    }
}
