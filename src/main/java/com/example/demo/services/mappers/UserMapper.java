package com.example.demo.services.mappers;

import com.example.demo.entities.User;
import com.example.demo.services.dtos.requests.user.AddUserRequest;
import com.example.demo.services.dtos.requests.user.UpdateUserRequest;
import com.example.demo.services.dtos.responses.user.AddUserResponse;
import com.example.demo.services.dtos.responses.user.GetAllUserResponse;
import com.example.demo.services.dtos.responses.user.GetByIdUserResponse;
import com.example.demo.services.dtos.responses.user.UpdateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    User addUserRequestToUser(AddUserRequest request);
    AddUserResponse userToAddUserResponse(User user);
    User updateUserRequestToUser(UpdateUserRequest request);
    UpdateUserResponse userToUpdateUserResponse(User user);
    GetAllUserResponse userToGetAllUserResponse(User user);
    GetByIdUserResponse userToGetByIdUserResponse(User user);
}
