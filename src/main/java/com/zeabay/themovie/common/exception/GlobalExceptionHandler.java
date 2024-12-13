package com.zeabay.themovie.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle BusinessException
     *
     * @param ex BusinessException
     * @return ResponseEntity<MovieErrorResponse>
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<MovieErrorResponse> handleBusinessException(BusinessException ex) {
        MovieErrorResponse response = new MovieErrorResponse(ex.getCode(), ex.getHttpStatus(), ex.getMessage());
        return new ResponseEntity<>(response, ex.getHttpStatus());
    }

    /**
     * Handle MethodArgumentNotValidException
     *
     * @param ex MethodArgumentNotValidException
     * @return ResponseEntity<MovieErrorResponse>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MovieErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        MovieErrorResponse response = new MovieErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                errors
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}