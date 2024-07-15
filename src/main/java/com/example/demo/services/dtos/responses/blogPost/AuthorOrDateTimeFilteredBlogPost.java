package com.example.demo.services.dtos.responses.blogPost;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuthorOrDateTimeFilteredBlogPost {
    private Integer id;
    private String title;
    private String content;
    private String authorUsername;
    private LocalDate releaseDate;

    public AuthorOrDateTimeFilteredBlogPost(Integer id, String title, String content, String authorUsername, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorUsername = authorUsername;
        this.releaseDate = releaseDate;
    }
}
