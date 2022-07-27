package com.hanghae.week03.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Exception {
    INVALID_ID("NULL_POST_ID", "post id isn't exist");

    private final String code;
    private final String message;
}
