package com.codewithkansal.Blog_Application.controller;

import com.codewithkansal.Blog_Application.payload.JWTAuthResponse;
import com.codewithkansal.Blog_Application.payload.LoginDTO;
import com.codewithkansal.Blog_Application.payload.RegisterDTO;
import com.codewithkansal.Blog_Application.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = {"/login","/signin"})
    public ResponseEntity<JWTAuthResponse>login(@RequestBody  LoginDTO loginDTO){
       String token= authService.Login(loginDTO);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
       //return ResponseEntity.ok(response);
    }

    @PostMapping(value = {"/register","/signup"})
    public ResponseEntity<String>register(@RequestBody RegisterDTO registerDTO){
        String response= authService.register(registerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
