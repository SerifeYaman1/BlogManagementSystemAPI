package com.example.demo.controllers;

import com.example.demo.services.abstracts.UserService;
import com.example.demo.services.dtos.requests.user.AddUserRequest;
import com.example.demo.services.dtos.requests.user.UpdateUserRequest;
import com.example.demo.services.dtos.responses.user.AddUserResponse;
import com.example.demo.services.dtos.responses.user.GetAllUserResponse;
import com.example.demo.services.dtos.responses.user.GetByIdUserResponse;
import com.example.demo.services.dtos.responses.user.UpdateUserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersContoller {
    private UserService userService;
    public UsersContoller(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("getAll")
    public List<GetAllUserResponse> getAllUser(){
        return userService.getAllUsers();
    }
    @GetMapping("getById/{id}")
    public GetByIdUserResponse getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @PostMapping("create")
    public AddUserResponse createUser(@RequestBody AddUserRequest request){
        return userService.createUser(request);
    }
    @PutMapping("update")
    public UpdateUserResponse updateUser(@RequestBody UpdateUserRequest request){
        return userService.updateUser(request);
    }
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
