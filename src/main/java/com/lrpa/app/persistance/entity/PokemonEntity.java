package com.lrpa.app.persistance.entity;

import com.lrpa.app.persistance.entity.audit.TemplateEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class PokemonEntity extends TemplateEntity {

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
    @Column(nullable = false, length = 50)
    private String funFact;
}
