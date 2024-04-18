package com.example.billingbackend.controller;

import com.example.billingbackend.entity.LoginEtity;
import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.security.JwtUtil;
import com.example.billingbackend.service.UserService;
import com.example.billingbackend.service.imp.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {

    public JwtUtil JwtUtil;
    private AuthenticationManager authenticationManager;
    UserService UserService;
//    UserServiceImpl UserServiceImpl;

    @GetMapping("api/login")
    public ResponseEntity<String> jwtTest (@RequestBody LoginEtity requestData){

        String userName = requestData.getUsername();
        String password = requestData.getPassword();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password);

        authenticationManager.authenticate(token);

        String jetToken = JwtUtil.generateJwt(userName);
        return ResponseEntity.ok(jetToken) ;
    }

    @PostMapping("api/register")
    public String register(@RequestBody UserEntity request){
        System.out.println("<<<<<<<<<< api data >>>>> " + request);
        UserService.userRegister(request);
//        UserServiceImpl.userRegister(request);
        return "ok";
    }
}
