package com.example.platformormanagingahotel.business.api.mappers;

import com.example.platformormanagingahotel.business.api.dto.HotelDto;
import com.example.platformormanagingahotel.business.api.entities.HotelEntity;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public HotelEntity mapToHotel(HotelDto hotelDto) {
        HotelEntity hotel = new HotelEntity();
        hotel.setName(hotelDto.getName());
        hotel.setNumOfStars(hotelDto.getNumOfStars());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setDescription(hotelDto.getDescription());
        return hotel;
    }

    public HotelDto mapToHotelDto(HotelEntity entity) {
        HotelDto dto = new HotelDto();
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setDescription(entity.getBillingInfo());
        dto.setNumOfStars(entity.getNumOfStars());
        return dto;
    }
}
