package com.hanghae.week03.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommonResponseDto {
    private boolean success;
    private Error error;
}
