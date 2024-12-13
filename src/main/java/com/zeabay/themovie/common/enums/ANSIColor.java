package com.zeabay.themovie.common.enums;

import lombok.Getter;

@Getter
public enum ANSIColor {
    RESET("\u001B[0m"),
    GREEN("\u001B[32m"),
    RED("\u001B[31m"),
    YELLOW("\u001B[33m"),
    CYAN("\u001B[36m");

    private final String code;

    ANSIColor(String code) {
        this.code = code;
    }
}