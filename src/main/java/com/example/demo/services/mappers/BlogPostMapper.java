package com.example.demo.services.mappers;

import com.example.demo.entities.BlogPost;
import com.example.demo.services.dtos.requests.blogPost.AddBlogPostRequest;
import com.example.demo.services.dtos.requests.blogPost.UpdateBlogPostRequest;
import com.example.demo.services.dtos.responses.blogPost.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BlogPostMapper {
    BlogPostMapper INSTANCE = Mappers.getMapper(BlogPostMapper.class);

    @Mapping(target = "author.id", source = "authorId")
    BlogPost addBlogPostRequestToBlogPost(AddBlogPostRequest addBlogPostRequest);

    @Mapping(target = "authorId", source = "author.id")
    AddBlogPostResponse blogPostToAddBlogPostResponse(BlogPost blogPost);

    @Mapping(target = "author.id", source = "authorId")
    BlogPost updateBlogPostRequestToBlogPost(UpdateBlogPostRequest updateBlogPostRequest);

    @Mapping(target = "authorId", source = "author.id")
    UpdateBlogPostResponse blogPostToUpdateBlogPostResponse(BlogPost blogPost);

    @Mapping(target = "authorName", source = "author.username")
    GetAllBlogPostResponse blogPostToGetAllBlogPostResponse(BlogPost blogPost);

    @Mapping(target = "authorId", source = "author.id")
    GetByIdBlogPostResponse blogPostToGetByIdBlogPostResponse(BlogPost blogPost);

    AuthorOrDateTimeFilteredBlogPost blogPostToAuthorOrDateTimeFilteredBlogPost(BlogPost blogPost);
    @Mapping(target = "authorName", source = "author.username")
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    GetByCategoryNameBlogPostResponse blogPostToGetByCategoryNameBlogPostResponse(BlogPost blogPost);
}
