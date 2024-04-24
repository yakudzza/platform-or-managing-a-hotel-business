package com.example.platformormanagingahotel.business.api.services;

import com.example.platformormanagingahotel.business.api.entities.User;
import com.example.platformormanagingahotel.business.api.entities.enums.Role;
import com.example.platformormanagingahotel.business.api.exceptions.NotFoundException;
import com.example.platformormanagingahotel.business.api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  /*  private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user){
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new NotFoundException("A user with this " + user.getEmail() + " exists");
            return false;
        }
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.CLIENT);

    }*/
}
