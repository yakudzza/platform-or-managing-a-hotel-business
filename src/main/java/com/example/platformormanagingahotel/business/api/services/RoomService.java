package com.example.platformormanagingahotel.business.api.services;

import com.example.platformormanagingahotel.business.api.dto.RoomDto;
import com.example.platformormanagingahotel.business.api.entities.Room;
import com.example.platformormanagingahotel.business.api.mappers.RoomMapper;
import com.example.platformormanagingahotel.business.api.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomMapper roomMapper;


    public RoomDto addRoom(RoomDto roomDto){

        roomRepository.save(roomMapper.mapToRoom(roomDto));
        return roomDto;
    }

    public RoomDto findRoomById(Long id){
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()){
            return roomMapper.mapToRoomDto(room.get());
        }
        else {
            return null;
        }
    }
}
