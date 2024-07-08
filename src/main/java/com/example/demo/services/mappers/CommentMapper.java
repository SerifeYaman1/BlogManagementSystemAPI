package com.example.demo.services.mappers;

import com.example.demo.entities.Comment;
import com.example.demo.services.dtos.requests.comment.AddCommentRequest;
import com.example.demo.services.dtos.requests.comment.UpdateCommentRequest;
import com.example.demo.services.dtos.responses.comment.AddCommentResponse;
import com.example.demo.services.dtos.responses.comment.GetAllCommentResponse;
import com.example.demo.services.dtos.responses.comment.GetByIdCommentResponse;
import com.example.demo.services.dtos.responses.comment.UpdateCommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE= Mappers.getMapper(CommentMapper.class);
    @Mapping(target="user.id",source = "userId")
    @Mapping(target="blogPost.id",source = "postId")
    Comment addCommentRequestToComment(AddCommentRequest addCommentRequest);
    @Mapping(target="userId",source = "user.id")
    @Mapping(target="postId",source = "blogPost.id")
    AddCommentResponse commentToAddCommentResponse(Comment comment);
    @Mapping(target="user.id",source = "userId")
    @Mapping(target="blogPost.id",source = "postId")
    Comment updateCommentRequestToComment(UpdateCommentRequest updateCommentRequest);
    @Mapping(target="userId",source = "user.id")
    @Mapping(target="postId",source = "blogPost.id")
    UpdateCommentResponse commentToUpdateCommentResponse(Comment comment);
    @Mapping(target="userId",source = "user.id")
    @Mapping(target="postId",source = "blogPost.id")
    GetAllCommentResponse commentToGetAllCommentResponse(Comment comment);
    @Mapping(target="userId",source = "user.id")
    @Mapping(target="postId",source = "blogPost.id")
    GetByIdCommentResponse commentToGetByIdCommentResponse(Comment comment);
}
