package com.hanghae.week03.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public PostResponseDto(Post post) {
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
