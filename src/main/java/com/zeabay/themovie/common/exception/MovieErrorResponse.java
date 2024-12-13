package com.zeabay.themovie.common.exception;

import org.springframework.http.HttpStatus;

public record MovieErrorResponse(int code, HttpStatus status, String message) {
}