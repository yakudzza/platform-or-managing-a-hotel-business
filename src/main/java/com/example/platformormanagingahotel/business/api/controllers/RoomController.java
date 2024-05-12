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
    public String getRoomInfoPage(@RequestParam Long id,Model model){

        model.addAttribute("room", roomService.findRoomById(id));
        return "room_info";
    }
    @PutMapping("/book")
    public String bookRoom(@RequestBody RoomDto roomDto, Model model){
        roomService.bookRoom(roomDto);
        model.addAttribute("room", roomService.findRoomById(roomDto.getId()));
        return "room_info";
    }

    @GetMapping("/add")
    public String showAddRoomForm(@RequestParam("hotelId") Long id, Model model) {
        model.addAttribute("hotelId", id);
        return "add_room";
    }
    @PostMapping()
    public String addRoom(RoomDto roomDto, @RequestParam("hotelId")Long id){
        roomService.addRoom(roomDto, id);
        return "redirect:/home";
    }
}
