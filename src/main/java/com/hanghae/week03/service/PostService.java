package com.hanghae.week03.service;

import com.hanghae.week03.dto.PostPasswordRequestDto;
import com.hanghae.week03.dto.PostRequestDto;
import com.hanghae.week03.exception.InvalidIdException;
import com.hanghae.week03.model.*;
import com.hanghae.week03.repository.PostRepository;
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
        Post post = postRepository.findById(id).orElseThrow(InvalidIdException::new);
        post.update(requestDto);
        return post;
    }

    public Post find(Long id) {
        return postRepository.findById(id).orElseThrow(InvalidIdException::new);
    }

    public boolean delete(Long id) {
        try {
            postRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new InvalidIdException();
        }
        return true;
    }

    public boolean checkPassword(Long id, PostPasswordRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(InvalidIdException::new);
        return post.getPassword().equals(requestDto.getPassword());
    }
}
