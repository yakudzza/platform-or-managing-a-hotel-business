package com.example.platformormanagingahotel.business.api.mappers;

import com.example.platformormanagingahotel.business.api.dto.RoomDto;
import com.example.platformormanagingahotel.business.api.entities.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public Room mapToRoom(RoomDto roomDto){

        Room room = new Room();

        room.setBooked(roomDto.isBooked());
        room.setFloor(roomDto.getFloor());
        room.setType(roomDto.getType());
        return room;
    }

    public RoomDto mapToRoomDto(Room room){

        RoomDto roomDto = new RoomDto();

        roomDto.setId(room.getId());
        roomDto.setFloor(room.getFloor());
        roomDto.setBooked(room.isBooked());
        roomDto.setType(room.getType());
        return roomDto;
    }
}
