package com.codewithkansal.Blog_Application.service.Impl;

import com.codewithkansal.Blog_Application.entity.Role;
import com.codewithkansal.Blog_Application.entity.User;
import com.codewithkansal.Blog_Application.exception.BlogAPIException;
import com.codewithkansal.Blog_Application.payload.LoginDTO;
import com.codewithkansal.Blog_Application.payload.RegisterDTO;
import com.codewithkansal.Blog_Application.repository.RoleRepository;
import com.codewithkansal.Blog_Application.repository.UserRepository;
import com.codewithkansal.Blog_Application.security.JwtTokenProvider;
import com.codewithkansal.Blog_Application.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager
    ,PasswordEncoder passwordEncoder,UserRepository userRepository,RoleRepository roleRepository,JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtTokenProvider=jwtTokenProvider;
    }

    @Override
    public String Login(LoginDTO loginDTO) {
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsernameorEmail(),
                loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);

        return token;
        //return "User Logged in successfully";
    }



    @Override
    public String register(RegisterDTO registerDTO) {
        //check user exist or not
        if(userRepository.existsByUsername(registerDTO.getUsername())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"User already exist");
        }

        //check email already exist
        if(userRepository.existsByEmail(registerDTO.getEmail())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Email already exist");
        }

        User user=new User();
        user.setName(registerDTO.getName());
        user.setUserName(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Set<Role> roles=new HashSet<>();
        Role userRole=roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);
        return "User Register Successfully";
    }
}
