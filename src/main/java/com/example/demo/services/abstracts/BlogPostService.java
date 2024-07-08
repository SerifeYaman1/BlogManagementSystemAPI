package com.example.demo.services.abstracts;

import com.example.demo.services.dtos.requests.blogPost.AddBlogPostRequest;
import com.example.demo.services.dtos.requests.blogPost.UpdateBlogPostRequest;
import com.example.demo.services.dtos.responses.blogPost.AddBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.GetAllBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.GetByIdBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.UpdateBlogPostResponse;

import java.util.List;

public interface BlogPostService {

    AddBlogPostResponse createBlogPost(AddBlogPostRequest request);

    UpdateBlogPostResponse updateBlogPost(UpdateBlogPostRequest request);

    List<GetAllBlogPostResponse> getAllBlogPosts();
    void deleteBlogPost(int id);
    GetByIdBlogPostResponse getBlogPostById(int id);
}
