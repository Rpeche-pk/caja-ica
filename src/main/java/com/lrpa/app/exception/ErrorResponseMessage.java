package com.lrpa.app.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static java.util.Objects.isNull;

/**
 * @author ROMULO
 * @package com.lrpa.app.exception
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@Getter
@AllArgsConstructor
public class ErrorResponseMessage {
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeStamp;
    private Collection<ErrorMessage> errors;
    private String path;
    private int status;

    @Builder
    public ErrorResponseMessage(String message, String path, int status, Collection<ErrorMessage> errors) {
        this.message = message;
        this.timeStamp = LocalDateTime.now();
        this.errors = isNull(errors) ? List.of() : errors;;
        this.path = path;
        this.status = status;
    }
}
