package com.example.demo.services.concretes;

import com.example.demo.entities.Like;
import com.example.demo.repositories.LikeRepository;
import com.example.demo.services.abstracts.LikeService;
import com.example.demo.services.dtos.requests.like.AddLikeRequest;
import com.example.demo.services.dtos.requests.like.UpdateLikeRequest;
import com.example.demo.services.dtos.responses.like.AddLikeResponse;
import com.example.demo.services.dtos.responses.like.GetAllLikeResponse;
import com.example.demo.services.dtos.responses.like.GetByIdLikeResponse;
import com.example.demo.services.dtos.responses.like.UpdateLikeResponse;
import com.example.demo.services.mappers.LikeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public AddLikeResponse createLike(AddLikeRequest request) {
        Like like= LikeMapper.INSTANCE.addLikeRequestToLike(request);
        Like savedLike = likeRepository.save(like);
        return LikeMapper.INSTANCE.likeToAddLikeResponse(savedLike);
    }
    @Override
    public UpdateLikeResponse updateLike(UpdateLikeRequest request) {
        Like like= LikeMapper.INSTANCE.updateLikeRequestToLike(request);
        Like updatedLike = likeRepository.save(like);
        return LikeMapper.INSTANCE.likeToUpdateLikeResponse(updatedLike);
    }
    @Override
    public void deleteLike(int id) {
        likeRepository.deleteById(id);
    }
    @Override
    public List<GetAllLikeResponse> getAllLikes() {
        List<Like> likes = likeRepository.findAll();
        return likes.stream()
                .map(LikeMapper.INSTANCE::likeToGetAllLikeResponse)
                .collect(Collectors.toList());
    }
    @Override
    public GetByIdLikeResponse getLikeById(int id) {
        Like like = likeRepository.findById(id).orElseThrow(() -> new RuntimeException("Like not found"));
        return LikeMapper.INSTANCE.likeToGetByIdLikeResponse(like);
    }
}
