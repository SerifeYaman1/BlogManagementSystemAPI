package com.example.demo.services.abstracts;

import com.example.demo.entities.User;
import com.example.demo.services.dtos.requests.user.RegisterRequest;
import com.example.demo.services.dtos.requests.user.UpdateUserRequest;
import com.example.demo.services.dtos.responses.user.AddUserResponse;
import com.example.demo.services.dtos.responses.user.GetAllUserResponse;
import com.example.demo.services.dtos.responses.user.GetByIdUserResponse;
import com.example.demo.services.dtos.responses.user.UpdateUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
//Servis Spring Security'in gerektirdiği yapıyı karşılaması için UserDetailsService extends etmesi gerekir.
public interface UserService extends UserDetailsService {
    UpdateUserResponse updateUser(UpdateUserRequest request);
    List<GetAllUserResponse> getAllUsers();
    void deleteUser(int id);
    GetByIdUserResponse getUserById(int id);
    void add(User user);
}
