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

    public PostBooleanResponseDto getPostBooleanResponseDto() {
        PostBooleanResponseDto postBooleanResponseDto = new PostBooleanResponseDto();
        setSuccessResponse(postBooleanResponseDto);
        return postBooleanResponseDto;
    }

    public PostBooleanResponseDto getPostBooleanResponseDto(boolean data) {
        PostBooleanResponseDto postBooleanResponseDto = new PostBooleanResponseDto(data);
        setSuccessResponse(postBooleanResponseDto);
        return postBooleanResponseDto;
    }

    private void setSuccessResponse(CommonResponseDto responseDto) {
        responseDto.setSuccess(true);
        responseDto.setError(null);
    }

    public PostSingleResponseDto getErrorResponse(String code, String message) {
        return new PostSingleResponseDto(code, message);
    }
}
