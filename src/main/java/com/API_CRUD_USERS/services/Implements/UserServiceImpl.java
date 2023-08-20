package com.API_CRUD_USERS.services.Implements;

import com.API_CRUD_USERS.dtos.UserRegisterDto;
import com.API_CRUD_USERS.models.UserModel;
import com.API_CRUD_USERS.repositories.UserJpaRepository;
import com.API_CRUD_USERS.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;

    public UserServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @CachePut(cacheNames = "user", key = "#result.uuid", unless = "#result == null")
    @Override
    public UserModel saveUser(UserRegisterDto userRegisterDto) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userRegisterDto, userModel);
        UserModel savedUser = userJpaRepository.save(userModel);
        return savedUser;
    }

    @Cacheable(cacheNames = "user", key = "#uuid", unless = "#result == null")
    @Override
    public UserModel findUserById(UUID uuid) {
        return userJpaRepository.findById(uuid).orElse(null);
    }

    @Cacheable(cacheNames = "user", key = "#username", unless = "#result == null")
    @Override
    public UserModel findByUsername(String username) {
        return userJpaRepository.findByUsername(username).orElse(null);
    }

    @CacheEvict(cacheNames = "user", key = "#uuid")
    @Override
    public UserModel updateUser (UUID uuid, UserModel user, UserRegisterDto userRegisterDto){
        BeanUtils.copyProperties(userRegisterDto, user, "uuid");
        return userJpaRepository.save(user);
    };

    @CacheEvict(cacheNames = "user", key = "#uuid")
    @Override
    public UserModel deleteUser(UUID uuid){
        userJpaRepository.deleteById(uuid);
        return userJpaRepository.findById(uuid).orElse(null);
    };

    @Override
    public String getTotalUsers(){
        return String.valueOf(userJpaRepository.count());
    }

    @Override
    public List<UserModel> getUsersByReference(String reference){
        return userJpaRepository.getUsersByReference(reference);
    };


}
