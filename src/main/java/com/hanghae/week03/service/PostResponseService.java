package com.hanghae.week03.service;

import com.hanghae.week03.model.CommonResponseDto;
import com.hanghae.week03.model.Post;
import com.hanghae.week03.model.PostListResponseDto;
import com.hanghae.week03.model.PostResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostResponseService {

    public PostListResponseDto getPostListResponse(List<Post> posts) {
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

    private void setSuccessResponse(CommonResponseDto responseDto) {
        responseDto.setSuccess(true);
        responseDto.setError(null);
    }
}
