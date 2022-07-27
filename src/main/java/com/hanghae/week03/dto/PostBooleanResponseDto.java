package com.hanghae.week03.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostBooleanResponseDto extends CommonResponseDto {
    private boolean data;

    public PostBooleanResponseDto(boolean data) {
        this.data = data;
    }
}
