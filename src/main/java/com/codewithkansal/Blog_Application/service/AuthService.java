package com.codewithkansal.Blog_Application.service;

import com.codewithkansal.Blog_Application.payload.LoginDTO;
import com.codewithkansal.Blog_Application.payload.RegisterDTO;

public interface AuthService {
    String Login(LoginDTO loginDTO);
    String register (RegisterDTO registerDTO);
}
