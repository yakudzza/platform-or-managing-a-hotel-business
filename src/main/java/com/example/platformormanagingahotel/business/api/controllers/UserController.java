package com.example.platformormanagingahotel.business.api.controllers;

import com.example.platformormanagingahotel.business.api.entities.UserEntity;
import com.example.platformormanagingahotel.business.api.exceptions.NotFoundException;
import com.example.platformormanagingahotel.business.api.repositories.UserRepository;
import com.example.platformormanagingahotel.business.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    @GetMapping("/login")
    public String login() {
        return "custom_login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "custom_registration";
    }


    @PostMapping("/registration")
    public String createUser(UserEntity user, Model model) {
        try {
            userService.createUser(user);
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
            return "custom_registration";
        }
    }

    @GetMapping("/info{id}")
    public String userInfo(Model model, Principal principal){
        String username = principal.getName(); // Получаем имя пользователя
        UserEntity user = userRepository.findByEmail(username) // Ищем пользователя по имени (email)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден: " + username));
        model.addAttribute("user", user); // Передаем пользователя в модель

        return "home_user"; // Возвращаем имя представления для отображения информации о пользователе
    }



}

