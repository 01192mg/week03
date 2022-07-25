package com.hanghae.week03.service;

import com.hanghae.week03.exception.InvalidIdException;
import com.hanghae.week03.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new InvalidIdException("아이디가 존재하지 않습니다."));
        post.update(requestDto);
        return post;
    }

    public Post find(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new InvalidIdException("아이디가 존재하지 않습니다."));
    }

    public void delete(Long id) {
        try {
            postRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new InvalidIdException("아이디가 존재하지 않습니다.");
        }
    }

    public boolean checkPassword(Long id, PostPasswordRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new InvalidIdException("아이디가 존재하지 않습니다."));
        return post.getPassword().equals(requestDto.getPassword());
    }
}
