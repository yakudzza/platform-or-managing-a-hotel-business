package com.example.platformormanagingahotel.business.api.controllers;

import com.example.platformormanagingahotel.business.api.dto.HotelDto;
import com.example.platformormanagingahotel.business.api.entities.HotelEntity;
import com.example.platformormanagingahotel.business.api.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/{id}")
    public String getHotelById(@PathVariable Long id, Model model) {

        model.addAttribute("hotel", hotelService.getHotelById(id));
        model.addAttribute("rooms", hotelService.getRoomsByHotelId(id));
        return "hotel_info";
    }

    @GetMapping("/add")
    public String addHotel(){
        return "add_hotel";
    }
    @PostMapping()
    public String addHotel(HotelDto hotelDto){
        hotelService.addHotel(hotelDto);
        return "redirect:/home";
    }

}
