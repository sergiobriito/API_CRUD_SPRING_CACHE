package com.API_CRUD_USERS.services;

import com.API_CRUD_USERS.dtos.UserRegisterDto;
import com.API_CRUD_USERS.models.UserModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserModel saveUser(UserRegisterDto userRegisterDto);
    UserModel findUserById(UUID uuid);
    UserModel findByUsername(String username);
    UserModel updateUser (UUID uuid, UserModel user, UserRegisterDto userRegisterDto);
    UserModel deleteUser(UUID uuid);
    List<UserModel> getUsersByReference(String reference);
    String getTotalUsers();
}
