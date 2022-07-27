package com.hanghae.week03.dto;

import com.hanghae.week03.exception.Exception;
import com.hanghae.week03.model.Error;
import com.hanghae.week03.model.Post;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostSingleResponseDto extends CommonResponseDto {
    private PostResponseDto data;

    public PostSingleResponseDto(Post post) {
        this.data = new PostResponseDto(post);
    }

    public PostSingleResponseDto(Exception e) {
        this.data = null;
        this.setError(new Error(e));
    }
}
