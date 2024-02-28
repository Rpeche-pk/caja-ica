package com.lrpa.app.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author ROMULO
 * @package com.lrpa.app.controller.dto.response
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
public record ResponseDto(
        String name,
        String type,
        String feeding,
        String size,
        String weight,
        String rarity,
        String funFact) {
}
