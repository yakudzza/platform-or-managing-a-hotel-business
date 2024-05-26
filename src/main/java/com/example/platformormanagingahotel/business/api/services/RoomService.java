package com.example.platformormanagingahotel.business.api.services;

import com.example.platformormanagingahotel.business.api.dto.RoomDto;
import com.example.platformormanagingahotel.business.api.entities.HotelEntity;
import com.example.platformormanagingahotel.business.api.entities.Image;
import com.example.platformormanagingahotel.business.api.entities.Room;
import com.example.platformormanagingahotel.business.api.entities.UserEntity;
import com.example.platformormanagingahotel.business.api.mappers.RoomMapper;
import com.example.platformormanagingahotel.business.api.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    ImageService imageService;

    @Autowired
    RoomService(ImageService imageService) {
        this.imageService = imageService;
    }


    public RoomDto addRoom(RoomDto roomDto, Long id, MultipartFile file) throws IOException {
        Room room = roomMapper.mapToRoom(roomDto);
        room.setHotel(hotelService.getHotelById(id));
        Image image;
        if (!file.isEmpty()) {
            image = imageService.toImageEntity(file);
            image.setPreviewImage(true);
            Image savedImage = imageService.saveImage(image);
            room.setImageId(savedImage.getId());
        }
        roomRepository.save(room);
        return roomMapper.mapToRoomDto(room);
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

    public Room findRoomById(Long id){
        Optional<Room> room = roomRepository.findById(id);
        return room.orElse(null);
    }
}
