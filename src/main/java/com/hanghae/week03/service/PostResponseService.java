package com.hanghae.week03.service;

import com.hanghae.week03.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostResponseService {

    public PostListResponseDto getPostListResponseDto(List<Post> posts) {
        List<PostResponseDto> responseDtoList = new ArrayList<>();
        for (Post post : posts) {
            PostResponseDto responseDto = new PostResponseDto(post);
            responseDtoList.add(responseDto);
        }
        PostListResponseDto postListResponseDto = new PostListResponseDto();
        postListResponseDto.setData(responseDtoList);
        setSuccessResponse(postListResponseDto);
        return postListResponseDto;
    }

    public PostSingleResponseDto getPostSingleResponseDto(Post post) {
        PostSingleResponseDto postSingleResponseDto = new PostSingleResponseDto(post);
        setSuccessResponse(postSingleResponseDto);
        return postSingleResponseDto;
    }

    private void setSuccessResponse(CommonResponseDto responseDto) {
        responseDto.setSuccess(true);
        responseDto.setError(null);
    }
}
