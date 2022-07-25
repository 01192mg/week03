package com.hanghae.week03.controller;

import com.hanghae.week03.model.*;
import com.hanghae.week03.service.PostResponseService;
import com.hanghae.week03.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
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
    public void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }

    @PostMapping("/api/posts/{id}")
    public boolean checkPassword(@PathVariable Long id, @RequestBody PostPasswordRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        return post.getPassword().equals(requestDto.getPassword());
    }
}
