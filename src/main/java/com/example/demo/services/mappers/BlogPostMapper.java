package com.example.demo.services.mappers;

import com.example.demo.entities.BlogPost;
import com.example.demo.entities.Comment;
import com.example.demo.entities.Like;
import com.example.demo.services.dtos.requests.blogPost.AddBlogPostRequest;
import com.example.demo.services.dtos.requests.blogPost.UpdateBlogPostRequest;
import com.example.demo.services.dtos.responses.blogPost.AddBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.GetAllBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.GetByIdBlogPostResponse;
import com.example.demo.services.dtos.responses.blogPost.UpdateBlogPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

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

    @Mapping(target = "authorId", source = "author.id")
    GetAllBlogPostResponse blogPostToGetAllBlogPostResponse(BlogPost blogPost);

    @Mapping(target = "authorId", source = "author.id")
    GetByIdBlogPostResponse blogPostToGetByIdBlogPostResponse(BlogPost blogPost);


}
