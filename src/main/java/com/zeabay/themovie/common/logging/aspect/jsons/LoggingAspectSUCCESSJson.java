package com.zeabay.themovie.common.logging.aspect.jsons;

public record LoggingAspectSUCCESSJson(String currentClass, String method, Object[] arguments, Object returnValue,
                                       String eventType) {
}