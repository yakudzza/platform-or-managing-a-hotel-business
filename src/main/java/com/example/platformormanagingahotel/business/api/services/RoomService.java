package com.example.platformormanagingahotel.business.api.services;

import com.example.platformormanagingahotel.business.api.dto.RoomDto;
import com.example.platformormanagingahotel.business.api.entities.Room;
import com.example.platformormanagingahotel.business.api.entities.UserEntity;
import com.example.platformormanagingahotel.business.api.mappers.RoomMapper;
import com.example.platformormanagingahotel.business.api.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    HotelService hotelService;

    @Autowired
    UserService userService;


    public RoomDto addRoom(RoomDto roomDto, Long id){

        Room room = roomMapper.mapToRoom(roomDto);
        room.setHotel(hotelService.getHotelById(id));
        roomRepository.save(room);
        return roomDto;
    }

    public List<Room> listRooms(){
        return (List<Room>) roomRepository.findAll();
    }

    public RoomDto bookRoom(Long id){
        UserEntity userEntity = userService.getCurrentUser();
        Room room = roomRepository.findById(id).get();
        room.setBooked(true);
        room.setUser(userEntity);
        Room room1 = roomRepository.saveAndFlush(room);
        userEntity.setRoom(room);
        userService.saveUser(userEntity);
        return roomMapper.mapToRoomDto(room1);
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
