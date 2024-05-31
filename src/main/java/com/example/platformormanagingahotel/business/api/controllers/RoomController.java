package com.example.platformormanagingahotel.business.api.controllers;


import com.example.platformormanagingahotel.business.api.dto.RoomDto;
import com.example.platformormanagingahotel.business.api.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path ="/room")
public class RoomController {

    @Autowired
    RoomService roomService;
    @GetMapping("/book")
    public String getBookRoomPage(Model model){

        model.addAttribute("rooms", roomService.listRooms());
        return "hotel_info";
    }
    @GetMapping("/{id}")
    public String getRoomInfoPage(@PathVariable Long id,Model model){

        model.addAttribute("room", roomService.findRoomById(id));
        return "room_info";
    }

    @GetMapping("/thank_you")
    public String thank(){
        return "thank_you";
    }
    @GetMapping("/book/{id}")
    public String bookRoom(@PathVariable Long id, Model model){
        RoomDto roomDto = roomService.bookRoom(id);
        model.addAttribute("room", roomService.findRoomById(roomDto.getId()));
        //return "room_info";
        return "redirect:/room/thank_you";
    }
}
