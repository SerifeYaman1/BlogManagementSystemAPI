package com.example.demo.services.mappers;

import com.example.demo.entities.Like;
import com.example.demo.services.dtos.requests.like.AddLikeRequest;
import com.example.demo.services.dtos.requests.like.UpdateLikeRequest;
import com.example.demo.services.dtos.responses.like.AddLikeResponse;
import com.example.demo.services.dtos.responses.like.GetAllLikeResponse;
import com.example.demo.services.dtos.responses.like.GetByIdLikeResponse;
import com.example.demo.services.dtos.responses.like.UpdateLikeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LikeMapper {
    LikeMapper INSTANCE= Mappers.getMapper(LikeMapper.class);
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "blogPost.id", source = "postId")
    Like addLikeRequestToLike(AddLikeRequest request);
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "postId", source = "blogPost.id")
    AddLikeResponse likeToAddLikeResponse(Like like);
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "blogPost.id", source = "postId")
    Like updateLikeRequestToLike(UpdateLikeRequest request);
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "postId", source = "blogPost.id")
    UpdateLikeResponse likeToUpdateLikeResponse(Like like);
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "postId", source = "blogPost.id")
    GetByIdLikeResponse likeToGetByIdLikeResponse(Like like);
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "postId", source = "blogPost.id")
    GetAllLikeResponse likeToGetAllLikeResponse(Like like);

}
