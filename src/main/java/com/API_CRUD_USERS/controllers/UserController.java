package com.API_CRUD_USERS.controllers;


import com.API_CRUD_USERS.dtos.UserRegisterDto;
import com.API_CRUD_USERS.models.UserModel;
import com.API_CRUD_USERS.services.Implements.UserServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userService) {
        this.userServiceImpl = userService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserRegisterDto userRegisterDto){
        UserModel username = userServiceImpl.findByUsername(userRegisterDto.getUsername());
        if (username != null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Username already in use");
        }
        UserModel savedUser = userServiceImpl.saveUser(userRegisterDto);
        if (savedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not saved");
        };
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/users/" + savedUser.getUuid().toString())
                .body(savedUser);
    };

    @GetMapping("/{uuid}")
    public ResponseEntity<Object> getUser(@PathVariable(value = "uuid") UUID uuid){
        UserModel user = userServiceImpl.findUserById(uuid);
        if (user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        };
        return ResponseEntity.status(HttpStatus.OK).body(user);
    };

    @Transactional
    @PutMapping("/{uuid}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "uuid") UUID uuid,@RequestBody @Valid UserRegisterDto userRegisterDto){
        UserModel user = userServiceImpl.findUserById(uuid);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        };
        UserModel updatedUser = userServiceImpl.updateUser(uuid, user, userRegisterDto);
        if (updatedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not updated");
        };
        return ResponseEntity.status(HttpStatus.OK).body("User updated successfuly");
    };

    @Transactional
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "uuid") UUID uuid){
        UserModel user = userServiceImpl.findUserById(uuid);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        };
        UserModel deletedUser = userServiceImpl.deleteUser(uuid);
        if (deletedUser != null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User not deleted");
        };
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfuly");
    };

    @GetMapping("/total-users")
    public ResponseEntity<Object> getTotalUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getTotalUsers());
    };

    @GetMapping
    public ResponseEntity<Object> getUsersByReference(@RequestParam(name = "t",required = true) String reference){
        return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getUsersByReference(reference));
    };


};




