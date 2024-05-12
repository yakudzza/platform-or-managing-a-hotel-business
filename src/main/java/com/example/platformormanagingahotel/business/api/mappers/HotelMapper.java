package com.example.platformormanagingahotel.business.api.mappers;

import com.example.platformormanagingahotel.business.api.dto.HotelDto;
import com.example.platformormanagingahotel.business.api.entities.HotelEntity;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public HotelEntity mapToHotel(HotelDto dto) {
        HotelEntity entity = new HotelEntity();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setBillingInfo(dto.getBillingInfo());
        entity.setNumOfStars(dto.getNumOfStars());
        return entity;
    }

    public HotelDto mapToHotelDto(HotelEntity entity) {
        HotelDto dto = new HotelDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setBillingInfo(entity.getBillingInfo());
        dto.setNumOfStars(entity.getNumOfStars());
        return dto;
    }
}
