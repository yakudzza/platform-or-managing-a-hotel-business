package com.example.platformormanagingahotel.business.api.services;


import com.example.platformormanagingahotel.business.api.entities.UserEntity;
import com.example.platformormanagingahotel.business.api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(UserEntity user){
        if (userRepository.existsByEmail(user.getEmail())){
            throw new UsernameNotFoundException("Пользователь с таким " +  user.getEmail() + " уже зарегистрирован");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return true;
    }

    public Optional<UserEntity> userInfo(UserEntity user){
        return userRepository.findById(user.getId());
    }

}
