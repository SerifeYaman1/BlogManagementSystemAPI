package com.example.demo.services.dtos.responses.blogPost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UpdateBlogPostResponse {
    private int id;
    private String title;
    private String content;
    private LocalDateTime releaseDate;
    private int likesCount;
    private int commentsCount;
    private int authorId;
}
