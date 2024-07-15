package com.example.demo.controllers;


import com.example.demo.core.utils.result.DataResult;
import com.example.demo.services.abstracts.BlogPostService;
import com.example.demo.services.dtos.requests.blogPost.AddBlogPostRequest;
import com.example.demo.services.dtos.requests.blogPost.UpdateBlogPostRequest;
import com.example.demo.services.dtos.responses.blogPost.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostsController {
    private BlogPostService blogPostService;

    public BlogPostsController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllBlogPostResponse>> getAllBlogPosts() throws InterruptedException {
        //Thread.sleep(5000);
        return blogPostService.getAllBlogPosts();
    }
    @GetMapping("/getById")
    public DataResult<GetByIdBlogPostResponse> getBlogPostById(@PathVariable int id) {
        return blogPostService.getBlogPostById(id);
    }
    @GetMapping("/getByAuthorOrDateTime")
    public DataResult<List<AuthorOrDateTimeFilteredBlogPost>> findBlogPosts(@RequestParam(required = false) String authorUsername, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate releaseDate) {
        return blogPostService.findBlogPosts(authorUsername, releaseDate);
    }
    @GetMapping("/getByCategoryName/{categoryName}")
    public DataResult<List<GetByCategoryNameBlogPostResponse>> getBlogPostsByCategoryName(@PathVariable String categoryName) {
        return blogPostService.findByCategory_NameIgnoreCase(categoryName);
    }
    @GetMapping("/getAllByPage/{pageNo}/{pageSize}")
    public DataResult<List<GetAllBlogPostResponse>> getAllBlogPosts(@PathVariable int pageNo, @PathVariable int pageSize) {
        return blogPostService.getAllBlogPosts(pageNo, pageSize);
    }
    @PostMapping("/create")
    public DataResult<AddBlogPostResponse> createBlogPost(@RequestBody AddBlogPostRequest request) {
        return blogPostService.createBlogPost(request);
    }
    @PutMapping("/update")
    public DataResult<UpdateBlogPostResponse> updateBlogPost(@RequestBody UpdateBlogPostRequest request) {
        return blogPostService.updateBlogPost(request);
    }
    @DeleteMapping("/delete")
    public void deleteBlogPost(int id) {
        blogPostService.deleteBlogPost(id);
    }
}
