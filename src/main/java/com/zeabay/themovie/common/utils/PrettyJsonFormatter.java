package com.zeabay.themovie.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class PrettyJsonFormatter {
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public static String format(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            return object.toString();
        }
    }
}