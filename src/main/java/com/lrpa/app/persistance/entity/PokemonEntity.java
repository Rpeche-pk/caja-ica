package com.lrpa.app.persistance.entity;

import com.lrpa.app.controller.dto.request.PokeRequestDto;
import com.lrpa.app.persistance.entity.audit.Audit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.Objects;

/**
 * @author ROMULO
 * @package com.lrpa.app.persistance.entity
 * @license Lrpa, zephyr cygnus
 * @since 27/2/2024
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pokemon")
@Where(clause = "enabled=TRUE")
public class PokemonEntity extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String type;
    @Column(nullable = false, length = 50)
    private String feeding;
    @Column(nullable = false, length = 50)
    private String size;
    @Column(nullable = false, length = 50)
    private String weight;
    @Column(nullable = false, length = 50)
    private String rarity;
    @Column(nullable = false, length = 250)
    private String funFact;

    private Boolean enabled;

    public PokemonEntity updatePokemon(PokeRequestDto requestDto) {
        if (Objects.nonNull(requestDto.getName())) this.setName(requestDto.getName().strip());
        if (Objects.nonNull(requestDto.getType())) this.setType(requestDto.getType().strip());
        if (Objects.nonNull(requestDto.getFeeding())) this.setFeeding(requestDto.getFeeding().strip());
        if (Objects.nonNull(requestDto.getSize())) this.setSize(requestDto.getSize().strip());
        if (Objects.nonNull(requestDto.getWeight())) this.setWeight(requestDto.getWeight().strip());
        if (Objects.nonNull(requestDto.getRarity())) this.setRarity(requestDto.getRarity().strip());
        if (Objects.nonNull(requestDto.getFunFact())) this.setFunFact(requestDto.getFunFact().strip());
        return this;
    }
}
