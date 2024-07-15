package com.example.demo.services.dtos.responses.blogPost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByCategoryNameBlogPostResponse {
    private int id;
    private String title;
    private String content;
    private String authorName;
    private LocalDate releaseDate;
    private int likesCount;
    private int commentsCount;
    private int categoryId;
    private String categoryName;
}
