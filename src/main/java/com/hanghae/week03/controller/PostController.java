package com.hanghae.week03.controller;

import com.hanghae.week03.model.Post;
import com.hanghae.week03.model.PostRepository;
import com.hanghae.week03.model.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts/{id}")
    public Post getPost(@PathVariable Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
    }
}
