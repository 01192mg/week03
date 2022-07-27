package com.hanghae.week03.dto;

import com.hanghae.week03.model.Error;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommonResponseDto {
    private boolean success;
    private Error error;
}
