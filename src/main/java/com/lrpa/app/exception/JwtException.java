package com.lrpa.app.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * @author ROMULO
 * @package com.lrpa.app.exception
 * @license Lrpa, zephyr cygnus
 * @since 29/2/2024
 */
@Getter
@Setter
public class JwtException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime timeStamp;
    private final int status;

    public JwtException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = LocalDateTime.now();
        this.status = httpStatus.value();
    }
}