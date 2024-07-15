package com.example.demo.services.abstracts;

import com.example.demo.core.utils.result.DataResult;
import com.example.demo.core.utils.result.Result;
import com.example.demo.services.dtos.requests.blogPost.AddBlogPostRequest;
import com.example.demo.services.dtos.requests.blogPost.UpdateBlogPostRequest;
import com.example.demo.services.dtos.responses.blogPost.*;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.zip.DataFormatException;

public interface BlogPostService {

    DataResult<AddBlogPostResponse> createBlogPost(AddBlogPostRequest request);

    DataResult<UpdateBlogPostResponse> updateBlogPost(UpdateBlogPostRequest request);

    DataResult<List<GetAllBlogPostResponse>> getAllBlogPosts();
    DataResult<List<GetAllBlogPostResponse>> getAllBlogPosts(int pageNo, int pageSize);

    Result deleteBlogPost(int id);

    DataResult<GetByIdBlogPostResponse> getBlogPostById(int id);

    DataResult<List<AuthorOrDateTimeFilteredBlogPost>> findBlogPosts(String authorUsername, LocalDate releaseDate);

    DataResult<List<GetByCategoryNameBlogPostResponse>> findByCategory_NameIgnoreCase(String categoryName);
}

