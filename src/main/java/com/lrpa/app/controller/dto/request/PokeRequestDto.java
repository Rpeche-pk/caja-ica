package com.lrpa.app.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonRootName;
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
public class PokeRequestDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private String type;
    private String feeding;
    private String size;
    private String weight;
    private String rarity;
    private String funFact;

}
