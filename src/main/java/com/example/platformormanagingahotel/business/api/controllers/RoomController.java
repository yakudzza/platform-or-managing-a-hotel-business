package com.example.platformormanagingahotel.business.api.controllers;


import com.example.platformormanagingahotel.business.api.dto.RoomDto;
import com.example.platformormanagingahotel.business.api.entities.Room;
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

    @PatchMapping
    public ResponseEntity<Long> bookRoom(){
        //todo
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<Long> addRoom(@RequestBody RoomDto roomDto){
        RoomDto roomDto1 = roomService.addRoom(roomDto);
        return ResponseEntity.ok().body(roomDto1.getId());
    }

    @GetMapping()
    public ResponseEntity<RoomDto> getRoomData(@RequestParam Long roomId){

        RoomDto roomDto = roomService.findRoomById(roomId);
        return ResponseEntity.ok().body(roomDto);
    }
}
