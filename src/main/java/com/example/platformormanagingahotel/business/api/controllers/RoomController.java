package com.example.platformormanagingahotel.business.api.controllers;


import com.example.platformormanagingahotel.business.api.dto.RoomDto;
import com.example.platformormanagingahotel.business.api.services.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/getRoomData")
    public ResponseEntity<RoomDto> getRoomData(@RequestParam Long id){

        RoomDto roomDto = roomService.findRoomById(id);
        return ResponseEntity.ok().body(roomDto);
    }
}
