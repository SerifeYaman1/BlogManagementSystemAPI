package com.example.demo.services.dtos.requests.blogPost;


import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter

public class UpdateBlogPostRequest {
    private int id;
    private String title;
    private String content;
    private LocalDate releaseDate;
    private int likesCount;
    private int commentsCount;
    private int authorId;
}
