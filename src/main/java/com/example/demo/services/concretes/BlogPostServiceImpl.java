package com.example.demo.services.concretes;

import com.example.demo.core.utils.result.*;
import com.example.demo.entities.BlogPost;
import com.example.demo.repositories.BlogPostRepository;
import com.example.demo.services.abstracts.BlogPostService;
import com.example.demo.services.dtos.requests.blogPost.AddBlogPostRequest;
import com.example.demo.services.dtos.requests.blogPost.UpdateBlogPostRequest;
import com.example.demo.services.dtos.responses.blogPost.*;
import com.example.demo.services.mappers.BlogPostMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostServiceImpl implements BlogPostService {
    private BlogPostRepository blogPostRepository;

    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }


    @Override
    public DataResult<AddBlogPostResponse> createBlogPost(AddBlogPostRequest request) {
        BlogPost blogPost= BlogPostMapper.INSTANCE.addBlogPostRequestToBlogPost(request);
        BlogPost savedBlogPost=blogPostRepository.save(blogPost);
        return new SuccessDataResult<AddBlogPostResponse>( BlogPostMapper.INSTANCE.blogPostToAddBlogPostResponse(savedBlogPost),"Blog post created");
    }
    @Override
    public DataResult<UpdateBlogPostResponse> updateBlogPost(UpdateBlogPostRequest request) {
        BlogPost blogPost =BlogPostMapper.INSTANCE.updateBlogPostRequestToBlogPost(request);
        BlogPost updatedBlogPost=blogPostRepository.save(blogPost);
        return new SuccessDataResult<UpdateBlogPostResponse>(BlogPostMapper.INSTANCE.blogPostToUpdateBlogPostResponse(updatedBlogPost));
    }
    @Override
    public DataResult<List<GetAllBlogPostResponse>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostRepository.findAll();
        if (!blogPosts.isEmpty()) {
            List<GetAllBlogPostResponse> responseList = blogPosts.stream()
                    .map(BlogPostMapper.INSTANCE::blogPostToGetAllBlogPostResponse)
                    .collect(Collectors.toList());
            return new SuccessDataResult<>(responseList, "Blog posts listed");
        } else {
            return new ErrorDataResult<>("No blog posts found");
        }
    }
    @Override
    public DataResult<List<GetAllBlogPostResponse>> getAllBlogPosts(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize); // pageNo 1'den başladığı için -1 yapıyoruz
        Page<BlogPost> blogPostPage = blogPostRepository.findAll(pageable);
        List<GetAllBlogPostResponse> responses = blogPostPage.getContent().stream()
                .map(BlogPostMapper.INSTANCE::blogPostToGetAllBlogPostResponse)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBlogPostResponse>>(responses, "Blog posts listed");
    }
    @Override
    public Result deleteBlogPost(int id) {
        BlogPost blogPost= blogPostRepository.findById(id).orElseThrow(()->new RuntimeException("Blog post not found"));
        blogPostRepository.deleteById(id);
        return new SuccessResult("Blog post deleted");
    }
    @Override
    public DataResult<GetByIdBlogPostResponse> getBlogPostById(int id) {
        BlogPost blogPost=blogPostRepository.findById(id).orElseThrow(()->new RuntimeException("Blog post not found"));
        return new SuccessDataResult<GetByIdBlogPostResponse>( BlogPostMapper.INSTANCE.blogPostToGetByIdBlogPostResponse(blogPost),"Blog post found");
    }
    public DataResult<List<AuthorOrDateTimeFilteredBlogPost>>findBlogPosts(String authorUsername, LocalDate releaseDate) {
        if (authorUsername != null && releaseDate != null) {
            return blogPostRepository.findByAuthorAndReleaseDate(authorUsername, releaseDate);
        } else if (authorUsername != null) {
            return blogPostRepository.findByAuthorUsername(authorUsername);
        } else if (releaseDate != null) {
            return blogPostRepository.findByReleaseDate(releaseDate);
        } else {
            // Eğer her iki parametre de null ise tüm blog yazılarını getir
            return new SuccessDataResult<List<AuthorOrDateTimeFilteredBlogPost>>(blogPostRepository.findAll().stream()
                    .map(bp -> new AuthorOrDateTimeFilteredBlogPost(bp.getId(), bp.getTitle(), bp.getContent(),
                            bp.getAuthor().getUsername(), bp.getReleaseDate()))
                    .collect(Collectors.toList()), "Blog posts listed")
                    ;
        }
    }

    @Override
    public DataResult<List<GetByCategoryNameBlogPostResponse>> findByCategory_NameIgnoreCase(String categoryName) {;
        List<BlogPost> blogPosts = blogPostRepository.findByCategory_NameIgnoreCase(categoryName);
        List<GetByCategoryNameBlogPostResponse> responses = blogPosts.stream().map(BlogPostMapper.INSTANCE::blogPostToGetByCategoryNameBlogPostResponse).collect(Collectors.toList());
        return new SuccessDataResult<List<GetByCategoryNameBlogPostResponse>>(responses, "Blog posts listed by category name");
    }
}