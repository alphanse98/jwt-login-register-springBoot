package com.example.billingbackend.service.imp;

import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.repository.UsersRepository;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    public UsersRepository UsersRepository;

    @Override
    public UserEntity userRegister(UserEntity request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        return UsersRepository.save(request);
    }
}
