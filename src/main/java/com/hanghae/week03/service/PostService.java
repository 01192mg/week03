package com.hanghae.week03.service;

import com.hanghae.week03.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public Post update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        post.update(requestDto);
        return post;
    }
}
