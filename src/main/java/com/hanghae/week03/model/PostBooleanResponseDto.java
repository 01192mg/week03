package com.hanghae.week03.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostBooleanResponseDto extends CommonResponseDto {
    private boolean data;

    public PostBooleanResponseDto() {
        this.data = true;
    }

    public PostBooleanResponseDto(boolean data) {
        this.data = data;
    }
}
