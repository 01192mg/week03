package com.hanghae.week03.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostListResponseDto extends CommonResponseDto {
    private List<PostResponseDto> data;
}
