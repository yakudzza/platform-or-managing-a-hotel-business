package com.example.platformormanagingahotel.business.api.controllers;

import com.example.platformormanagingahotel.business.api.dto.HotelDto;
import com.example.platformormanagingahotel.business.api.dto.RoomDto;
import com.example.platformormanagingahotel.business.api.services.HotelService;
import com.example.platformormanagingahotel.business.api.services.ImageService;
import com.example.platformormanagingahotel.business.api.services.RoomService;
import com.example.platformormanagingahotel.business.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AdminController {
    @Autowired
    HotelService hotelService;
    @Autowired
    RoomService roomService;
    @Autowired
    UserService userService;
    @Autowired
    ImageService imageService;

    @GetMapping("/admin/home")
    public String home(){
        return "home_admin";
    }

    @GetMapping("/admin/users")
    public String getAllUsers(Model model){
        model.addAttribute("users_list",userService.getAllUsers());
        return "users_info";
    }

    @GetMapping("/admin/hotels")
    public String getAllHotels(Model model){
        model.addAttribute("hotels_list",hotelService.getAllHotels());
        return "hotels_info";
    }

    @GetMapping("/room/add")
    public String showAddRoomForm(@RequestParam("hotelId") Long id, Model model) {
        model.addAttribute("hotelId", id);
        return "add_room";
    }
    @PostMapping("/room")
    public String addRoom(RoomDto roomDto, @RequestParam("hotelId")Long id, @RequestParam("image") MultipartFile file) throws IOException {
        roomService.addRoom(roomDto, id, file);
        return "home_admin";
    }

    @GetMapping("/admin/hotel/add")
    public String addHotel(){
        return "add_hotel";
    }
    @GetMapping("/admin/hotel/edit/{id}")
    public String editHotel(@PathVariable Long id, Model model){
        model.addAttribute("hotel",hotelService.getHotelById(id));
        return "edit_hotel";
    }

    @PostMapping("/admin/hotel/edit")
    public String editHotel(HotelDto hotelDto, @RequestParam("image") MultipartFile file) throws IOException{
        hotelService.editHotel(hotelDto, file);
        return "edit_hotel";
    }

    @PostMapping("/hotel")
    public String addHotel(HotelDto hotelDto, @RequestParam("image") MultipartFile file) throws IOException {
        hotelService.addHotel(hotelDto, file);
        return "home_admin";
    }

    @GetMapping("/admin/image/upload")
    public String uploadImage(){
        return "upload_image";
    }

    @PostMapping("admin/image/upload")
    public String uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        imageService.uploadImage(file);
        return "home_admin";
    }
}
