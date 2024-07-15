package com.example.demo.services.mappers;

import com.example.demo.entities.User;
import com.example.demo.services.dtos.requests.user.LoginRequest;
import com.example.demo.services.dtos.requests.user.RegisterRequest;
import com.example.demo.services.dtos.requests.user.UpdateUserRequest;
import com.example.demo.services.dtos.responses.user.AddUserResponse;
import com.example.demo.services.dtos.responses.user.GetAllUserResponse;
import com.example.demo.services.dtos.responses.user.GetByIdUserResponse;
import com.example.demo.services.dtos.responses.user.UpdateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    User registerRequestToUser(RegisterRequest request);
    User loginRequestToUser(LoginRequest request);
    User updateUserRequestToUser(UpdateUserRequest request);
    UpdateUserResponse userToUpdateUserResponse(User user);
    GetAllUserResponse userToGetAllUserResponse(User user);
    GetByIdUserResponse userToGetByIdUserResponse(User user);
}
