package com.example.platformormanagingahotel.business.api.services;


import com.example.platformormanagingahotel.business.api.entities.UserEntity;
import com.example.platformormanagingahotel.business.api.exceptions.NotFoundException;
import com.example.platformormanagingahotel.business.api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
            throw new UsernameNotFoundException("Пользователь с данной " +  user.getEmail() + " уже зарегистрирован");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setActive(true);
        userRepository.save(user);
        return true;
    }

    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        String username = authentication.getName();
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден: " + username));
    }



    public void updateUser(UserEntity updatedUser) {
        if (!userRepository.existsById(updatedUser.getId())) {
            throw new NotFoundException("Пользователь не существует");
        }

        userRepository.saveAndFlush(updatedUser);
    }



}
