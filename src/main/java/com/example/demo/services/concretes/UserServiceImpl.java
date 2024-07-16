package com.example.demo.services.concretes;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.abstracts.UserService;
import com.example.demo.services.dtos.requests.user.RegisterRequest;
import com.example.demo.services.dtos.requests.user.UpdateUserRequest;
import com.example.demo.services.dtos.responses.user.AddUserResponse;
import com.example.demo.services.dtos.responses.user.GetAllUserResponse;
import com.example.demo.services.dtos.responses.user.GetByIdUserResponse;
import com.example.demo.services.dtos.responses.user.UpdateUserResponse;
import com.example.demo.services.mappers.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest request) {
        User user= UserMapper.INSTANCE.updateUserRequestToUser(request);
        User updatedUser=userRepository.save(user);
        return UserMapper.INSTANCE.userToUpdateUserResponse(updatedUser);
    }
    @Override
    public List<GetAllUserResponse> getAllUsers() {
        List<User> users=userRepository.findAll();
        return users.stream()
                .map(UserMapper.INSTANCE::userToGetAllUserResponse)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    @Override
    public GetByIdUserResponse getUserById(int id) {
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        return UserMapper.INSTANCE.userToGetByIdUserResponse(user);
    }
    //Username'e göre kullanıcıyı nasıl entegre edeceğini burada belirler.
     //Veritabanından çekeceğimiz için userRepository'i entegre ederiz.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found!"));
    }
    public void add(User user) {
        userRepository.save(user);
    }
}
