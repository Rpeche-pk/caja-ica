package com.lrpa.app.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ROMULO
 * @package com.lrpa.app.controller.dto.request
 * @license Lrpa, zephyr cygnus
 * @since 27/2/2024
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "PokeRequestDto", description = "Dto collecting the data to be used")
public class PokeRequestDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "name is required")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚÜÑáéíóúüñ\\- ]{2,50}$|^$", message = "characters not allowed")
    @Schema(description = "Name of the pokemon", example = "Pikachu", defaultValue = "Pikachu")
    private String name;

    @NotBlank(message = "type is required")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚÜÑáéíóúüñ\\- ]{2,50}$|^$", message = "characters not allowed")
    @Schema(description = "Type of the pokemon", example = "Electric", defaultValue = "Electric")
    private String type;

    @NotBlank(message = "feeding is required")
    @Schema(description = "Feeding of the pokemon", example = "Omnívoro", defaultValue = "Omnívoro")
    private String feeding;

    @NotBlank(message = "size is required")
    @Schema(description = "Size of the pokemon", example = "pequeño", defaultValue = "pequeño")
    private String size;

    @NotBlank(message = "weight is required")
    @Schema(description = "Weight of the pokemon", example = "5kg", defaultValue = "5kg")
    private String weight;

    @NotBlank(message = "rarity is required")
    @Schema(description = "Rarity of the pokemon", example = "común", defaultValue = "común")
    private String rarity;


    private String funFact;

}
