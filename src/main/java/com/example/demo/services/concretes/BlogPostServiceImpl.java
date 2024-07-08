package com.example.demo.services.concretes;

import com.example.demo.entities.BlogPost;
import com.example.demo.repositories.BlogPostRepository;
import com.example.demo.services.abstracts.BlogPostService;
import com.example.demo.services.dtos.requests.blogPost.AddBlogPostRequest;
import com.example.demo.services.dtos.requests.blogPost.UpdateBlogPostRequest;
import com.example.demo.services.dtos.responses.blogPost.AddBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.GetAllBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.GetByIdBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.UpdateBlogPostResponse;
import com.example.demo.services.mappers.BlogPostMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostServiceImpl implements BlogPostService {
    private BlogPostRepository blogPostRepository;

    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public AddBlogPostResponse createBlogPost(AddBlogPostRequest request) {
        BlogPost blogPost= BlogPostMapper.INSTANCE.addBlogPostRequestToBlogPost(request);
        BlogPost savedBlogPost=blogPostRepository.save(blogPost);
        return BlogPostMapper.INSTANCE.blogPostToAddBlogPostResponse(savedBlogPost);
    }
    @Override
    public UpdateBlogPostResponse updateBlogPost(UpdateBlogPostRequest request) {
        BlogPost blogPost =BlogPostMapper.INSTANCE.updateBlogPostRequestToBlogPost(request);
        BlogPost updatedBlogPost=blogPostRepository.save(blogPost);
        return BlogPostMapper.INSTANCE.blogPostToUpdateBlogPostResponse(updatedBlogPost);
    }
    @Override
    public List<GetAllBlogPostResponse> getAllBlogPosts() {
        List<BlogPost> blogPosts=blogPostRepository.findAll();
        return blogPosts.stream()
                .map(BlogPostMapper.INSTANCE::blogPostToGetAllBlogPostResponse)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteBlogPost(int id) {
        BlogPost blogPost= blogPostRepository.findById(id).orElseThrow(()->new RuntimeException("Blog post not found"));
        blogPostRepository.deleteById(id);
    }
    @Override
    public GetByIdBlogPostResponse getBlogPostById(int id) {
        BlogPost blogPost=blogPostRepository.findById(id).orElseThrow(()->new RuntimeException("Blog post not found"));
        return BlogPostMapper.INSTANCE.blogPostToGetByIdBlogPostResponse(blogPost);
    }
}
