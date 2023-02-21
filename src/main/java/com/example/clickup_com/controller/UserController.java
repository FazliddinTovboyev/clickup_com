package com.example.clickup_com.controller;

import com.example.clickup_com.dto.APIResponse;
import com.example.clickup_com.dto.LoginDTO;
import com.example.clickup_com.dto.UserDTO;
import com.example.clickup_com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register-user")
    public HttpEntity<?> registerUser(@RequestBody UserDTO userDTO){
        APIResponse apiResponse = userService.registerUserService(userDTO);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }

    @GetMapping("/tasdiqlash")
    public HttpEntity<?> tasdiqlash(@RequestParam String email,@RequestParam String email_kod){
        APIResponse apiResponse = userService.emailtasdiqlash(email,email_kod);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDTO loginDTO){
        APIResponse apiResponse = userService.login(loginDTO);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
}
