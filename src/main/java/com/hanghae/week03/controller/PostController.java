package com.hanghae.week03.controller;

import com.hanghae.week03.model.*;
import com.hanghae.week03.service.PostResponseService;
import com.hanghae.week03.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final PostResponseService postResponseService;

    @GetMapping("/api/posts")
    public PostListResponseDto getPosts() {
        return postResponseService.getPostListResponseDto(postService.getPosts());
    }

    @PostMapping("/api/posts")
    public PostSingleResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postResponseService.getPostSingleResponseDto(postService.save(post));
    }

    @GetMapping("/api/posts/{id}")
    public PostSingleResponseDto getPost(@PathVariable Long id) {
        return postResponseService.getPostSingleResponseDto(postService.find(id));
    }

    @PutMapping("/api/posts/{id}")
    public PostSingleResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postResponseService.getPostSingleResponseDto(postService.update(id, requestDto));
    }

    @DeleteMapping("/api/posts/{id}")
    public PostBooleanResponseDto deletePost(@PathVariable Long id) {
        postService.delete(id);
        return postResponseService.getPostBooleanResponseDto();
    }

    @PostMapping("/api/posts/{id}")
    public PostBooleanResponseDto checkPassword(@PathVariable Long id, @RequestBody PostPasswordRequestDto requestDto) {
        return postResponseService.getPostBooleanResponseDto(postService.checkPassword(id, requestDto));
    }
}
