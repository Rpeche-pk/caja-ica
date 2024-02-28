package com.lrpa.app.exception;

/**
 * @author ROMULO
 * @package com.lrpa.app.exception
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
