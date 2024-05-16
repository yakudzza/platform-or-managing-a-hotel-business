package com.example.platformormanagingahotel.business.api.controllers;

import com.example.platformormanagingahotel.business.api.entities.UserEntity;
import com.example.platformormanagingahotel.business.api.repositories.UserRepository;
import com.example.platformormanagingahotel.business.api.services.HotelService;
import com.example.platformormanagingahotel.business.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final HotelService hotelService;
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

    @GetMapping("/home")
    public String homaPage(Model model){

        model.addAttribute("hotels", hotelService.getAllHotels());
        return "home";
    }

    @GetMapping("/user")
    public String getUserProfile(Model model) {
        UserEntity user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "user_profile";
    }

    @GetMapping("/user/update")
    public String getUpdateProfilePage(Model model) {
        UserEntity user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "user_edit";
    }

    @PostMapping("/user/update")
    public String updateUserProfile(@ModelAttribute UserEntity updatedUser) {
        userService.updateUser(updatedUser);
        return "redirect:/user";
    }

}

