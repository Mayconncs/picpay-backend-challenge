package com.picpay.picpaysimplificado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpay.picpaysimplificado.domain.user.User;
import com.picpay.picpaysimplificado.dtos.UserDTO;
import com.picpay.picpaysimplificado.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @PostMapping
    @Transactional
    public ResponseEntity<User> createUsers(@RequestBody @Valid UserDTO userDTO) {
        var user = userService.createUserInternal(userDTO);
       return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    
}
