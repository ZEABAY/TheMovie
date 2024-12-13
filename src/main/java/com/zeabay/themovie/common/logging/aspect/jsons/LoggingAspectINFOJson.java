package com.zeabay.themovie.common.logging.aspect.jsons;

public record LoggingAspectINFOJson(String currentClass, String method, Object[] arguments, String eventType) {
}