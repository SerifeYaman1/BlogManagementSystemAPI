package com.example.demo.services.abstracts;

import com.example.demo.services.dtos.requests.user.AddUserRequest;
import com.example.demo.services.dtos.requests.user.UpdateUserRequest;
import com.example.demo.services.dtos.responses.user.AddUserResponse;
import com.example.demo.services.dtos.responses.user.GetAllUserResponse;
import com.example.demo.services.dtos.responses.user.GetByIdUserResponse;
import com.example.demo.services.dtos.responses.user.UpdateUserResponse;

import java.util.List;

public interface UserService {
    AddUserResponse createUser(AddUserRequest request);
    UpdateUserResponse updateUser(UpdateUserRequest request);
    List<GetAllUserResponse> getAllUsers();
    void deleteUser(int id);
    GetByIdUserResponse getUserById(int id);
}
