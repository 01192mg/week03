package com.hanghae.week03.controller;

import com.hanghae.week03.exception.InvalidIdException;
import com.hanghae.week03.model.PostSingleResponseDto;
import com.hanghae.week03.service.PostResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {

    private final PostResponseService postResponseService;

    @ExceptionHandler(InvalidIdException.class)
    private PostSingleResponseDto invalidIdException(InvalidIdException e) {
        return postResponseService.getErrorResponse("NULL_POST_ID", e.getMessage());
    }
}
