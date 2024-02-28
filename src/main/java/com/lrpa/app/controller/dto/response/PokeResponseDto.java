package com.lrpa.app.controller.dto.response;

import java.time.LocalDateTime;

/**
 * @author ROMULO
 * @package com.lrpa.app.controller.dto.response
 * @license Lrpa, zephyr cygnus
 * @since 27/2/2024
 */
record PokeResponseDto(
        String name,
        String message,
        LocalDateTime timeStamp
) {
}

