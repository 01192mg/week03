package com.hanghae.week03.model;

import com.hanghae.week03.exception.Exception;
import lombok.Getter;

@Getter
public class Error {
    private final String code;
    private final String message;

    public Error(Exception e) {
        this.code = e.getCode();
        this.message = e.getMessage();
    }
}
