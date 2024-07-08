package com.example.demo.services.abstracts;

import com.example.demo.services.dtos.requests.like.AddLikeRequest;
import com.example.demo.services.dtos.requests.like.UpdateLikeRequest;
import com.example.demo.services.dtos.responses.like.AddLikeResponse;
import com.example.demo.services.dtos.responses.like.GetAllLikeResponse;
import com.example.demo.services.dtos.responses.like.GetByIdLikeResponse;
import com.example.demo.services.dtos.responses.like.UpdateLikeResponse;

import java.util.List;

public interface LikeService {
    AddLikeResponse createLike(AddLikeRequest request);
    UpdateLikeResponse updateLike(UpdateLikeRequest request);
    void deleteLike(int id);
    List<GetAllLikeResponse> getAllLikes();
    GetByIdLikeResponse getLikeById(int id);
}
