package com.lrpa.app.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ROMULO
 * @package com.lrpa.app.exception
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@RestControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ErrorMessage> errorMessages = ex.getBindingResult().getFieldErrors()
                .stream().map(
                        e -> ErrorMessage.builder()
                                .field(e.getField())
                                .message(e.getDefaultMessage())
                                .build()
                ).toList();

        ErrorResponseMessage error = ErrorResponseMessage.builder()
                .message("Validation error")
                .errors(errorMessages)
                .path(request.getDescription(false).replace("uri=", ""))
                .status(status.value())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ProblemDetail handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(value = {GenericException.class})
    public ProblemDetail handleGenericException(GenericException ex, HttpServletRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setProperty("date", LocalDateTime.now().toString());
        problemDetail.setInstance(URI.create(request.getRequestURI()).normalize());

        return problemDetail;
    }
}
