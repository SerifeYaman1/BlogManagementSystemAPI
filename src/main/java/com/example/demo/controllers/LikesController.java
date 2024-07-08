package com.example.demo.controllers;

import com.example.demo.services.abstracts.LikeService;
import com.example.demo.services.dtos.requests.like.AddLikeRequest;
import com.example.demo.services.dtos.requests.like.UpdateLikeRequest;
import com.example.demo.services.dtos.responses.like.AddLikeResponse;
import com.example.demo.services.dtos.responses.like.GetAllLikeResponse;
import com.example.demo.services.dtos.responses.like.GetByIdLikeResponse;
import com.example.demo.services.dtos.responses.like.UpdateLikeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikesController {
    private LikeService likeService;

    public LikesController(LikeService likeService) {
        this.likeService = likeService;
    }
    @GetMapping("getAll")
    public List<GetAllLikeResponse> getAllLikes() {
        return likeService.getAllLikes();
    }
    @GetMapping("getLikeById/{id}")
    public GetByIdLikeResponse getLikeById(@PathVariable int id) {
        return likeService.getLikeById(id);
    }
    @PostMapping("create")
    public AddLikeResponse createLike(@RequestBody AddLikeRequest request) {
        return likeService.createLike(request);
    }
    @PutMapping("update")
    public UpdateLikeResponse updateLike(@RequestBody UpdateLikeRequest request) {
        return likeService.updateLike(request);
    }
    @DeleteMapping("delete/{id}")
    public void deleteLike(@PathVariable int id) {
        likeService.deleteLike(id);
    }
}
