package com.hanghae.week03.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostSingleResponseDto extends CommonResponseDto {
    private PostResponseDto data;

    public PostSingleResponseDto(Post post) {
        this.data = new PostResponseDto(post);
    }
}
