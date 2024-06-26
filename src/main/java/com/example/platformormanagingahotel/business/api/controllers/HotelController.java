package com.example.platformormanagingahotel.business.api.controllers;

import com.example.platformormanagingahotel.business.api.dto.HotelDto;
import com.example.platformormanagingahotel.business.api.entities.HotelEntity;
import com.example.platformormanagingahotel.business.api.services.HotelService;
import com.example.platformormanagingahotel.business.api.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;
    @Autowired
    ImageService imageService;

    @GetMapping("/{id}")
    public String getHotelById(@PathVariable Long id, Model model) {

        HotelEntity hotelEntity = hotelService.getHotelById(id);
        model.addAttribute("hotel", hotelEntity);
        model.addAttribute("rooms", hotelService.getRoomsByHotelId(id));
        model.addAttribute("images", imageService.getImageById(hotelEntity.getImageId()));
        return "hotel_info";
    }
}
