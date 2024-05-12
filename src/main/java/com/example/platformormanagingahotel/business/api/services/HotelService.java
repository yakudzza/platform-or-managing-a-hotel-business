package com.example.platformormanagingahotel.business.api.services;

import com.example.platformormanagingahotel.business.api.dto.HotelDto;
import com.example.platformormanagingahotel.business.api.entities.HotelEntity;
import com.example.platformormanagingahotel.business.api.entities.Room;
import com.example.platformormanagingahotel.business.api.mappers.HotelMapper;
import com.example.platformormanagingahotel.business.api.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelMapper hotelMapper;
    public List<HotelEntity> getAllHotels() {

        if (hotelRepository != null){
            return (List<HotelEntity>) hotelRepository.findAll();
        }
        else{
            return null;
        }
    }

    public HotelEntity getHotelById(Long id) {
        if (hotelRepository.findById(id).isPresent()){
            return hotelRepository.findById(id).get();
        }
        else{
            return null;
        }
    }
    public void addHotel(HotelDto hotelDto) {

        HotelEntity hotelEntity = hotelMapper.mapToHotel(hotelDto);
        hotelRepository.save(hotelEntity);
    }
    public List<Room> getRoomsByHotelId(Long id) {

        Optional<HotelEntity> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            return optionalHotel.get().getRoom();
        }
        return Collections.emptyList();
    }
}
