package com.lrpa.app.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.time.LocalDateTime;

/**
 * @author ROMULO
 * @package com.lrpa.app.controller.dto.response
 * @license Lrpa, zephyr cygnus
 * @since 27/2/2024
 */
@JsonRootName("data")
public record PokeResponseDto(
        String name,
        String status,
        String message,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime timeStamp
) {
}

