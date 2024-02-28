package com.lrpa.app.persistance.mapper;

import com.lrpa.app.controller.dto.request.PokeRequestDto;
import com.lrpa.app.controller.dto.response.PokeResponseDto;
import com.lrpa.app.controller.dto.response.ResponseDto;
import com.lrpa.app.persistance.entity.PokemonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author ROMULO
 * @package com.lrpa.app.persistance.mapper
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PokemonMapper {
    ResponseDto toResponseDto(PokemonEntity pokemonEntityList);

    PokemonEntity toPokemonEntity(PokeRequestDto requestDto);
}
