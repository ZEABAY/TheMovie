package com.zeabay.themovie.common.logging.aspect.jsons;

public record LoggingAspectEXCEPTIONJson(String currentClass, String method, Object[] arguments, String returnValue,
                                         String eventType) {
}