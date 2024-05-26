package com.example.platformormanagingahotel.business.api.services;


import com.example.platformormanagingahotel.business.api.entities.Image;
import com.example.platformormanagingahotel.business.api.entities.Room;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ImageService imageService;


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

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new NotFoundException("Пользователь не найден");
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

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public void updateUser(UserEntity updatedUser, MultipartFile file) throws IOException {
        UserEntity existingUser = userRepository.findById(updatedUser.getId())
                .orElseThrow(() -> new NotFoundException("Пользователь не существует"));

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setMiddleName(updatedUser.getMiddleName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
        existingUser.setPassportSeries(updatedUser.getPassportSeries());
        existingUser.setPassportNumber(updatedUser.getPassportNumber());
        existingUser.setCitizenship(updatedUser.getCitizenship());
        Image image;
        if (file!= null) {
            image = imageService.toImageEntity(file);
            Image savedImage = imageService.saveImage(image);
            existingUser.setImageId(savedImage.getId());
        }
        userRepository.saveAndFlush(existingUser);
    }

}
