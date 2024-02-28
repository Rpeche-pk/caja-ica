package com.lrpa.app.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author ROMULO
 * @package com.lrpa.app.exception
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */

@Getter
@Builder
@AllArgsConstructor
public final class ErrorMessage {
    private String message;
    private String field;
}
