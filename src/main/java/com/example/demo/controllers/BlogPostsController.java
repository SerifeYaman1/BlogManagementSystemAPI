package com.example.demo.controllers;

import com.example.demo.entities.BlogPost;
import com.example.demo.services.abstracts.BlogPostService;
import com.example.demo.services.dtos.requests.blogPost.AddBlogPostRequest;
import com.example.demo.services.dtos.requests.blogPost.UpdateBlogPostRequest;
import com.example.demo.services.dtos.responses.blogPost.AddBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.GetAllBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.GetByIdBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.UpdateBlogPostResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostsController {
    private BlogPostService blogPostService;

    public BlogPostsController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/getAll")
    public List<GetAllBlogPostResponse> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }
    @GetMapping("/getById")
    public GetByIdBlogPostResponse getBlogPostById(@PathVariable int id) {
        return blogPostService.getBlogPostById(id);
    }
    @PostMapping("/create")
    public AddBlogPostResponse createBlogPost(@RequestBody AddBlogPostRequest request) {
        return blogPostService.createBlogPost(request);
    }
    @PutMapping("/update")
    public UpdateBlogPostResponse updateBlogPost(@RequestBody UpdateBlogPostRequest request) {
        return blogPostService.updateBlogPost(request);
    }
    @DeleteMapping("/delete")
    public void deleteBlogPost(int id) {
        blogPostService.deleteBlogPost(id);
    }
}
