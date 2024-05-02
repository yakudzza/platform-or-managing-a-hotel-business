package com.example.platformormanagingahotel.business.api.services;


import com.example.platformormanagingahotel.business.api.entities.UserEntity;
import com.example.platformormanagingahotel.business.api.exceptions.NotFoundException;
import com.example.platformormanagingahotel.business.api.repositories.RoleRepository;
import com.example.platformormanagingahotel.business.api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public Optional<UserEntity> findByUserEmail (String email){
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = findByUserEmail(email).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь с таким '%s' не найден", email)
        ));
        return new User(
                user.getEmail(),
                user.getPassword(),
                user.getRoles().stream().map(
                        roleEntity -> new SimpleGrantedAuthority(
                                roleEntity.getName())).collect(Collectors.toList()
                )
        );
    }

    public void registerUser(UserEntity user){
        if (!userRepository.existsByEmail(user.getEmail())){
            throw new NotFoundException("Пользоваетль с таким '%s' не найден");
        }

        user.setRoles(List.of(roleRepository.findByName("ROLE_USER").get()));
        userRepository.save(user);
    }
}
