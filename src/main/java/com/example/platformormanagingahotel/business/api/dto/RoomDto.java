package com.example.platformormanagingahotel.business.api.dto;

import com.example.platformormanagingahotel.business.api.entities.HotelEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    Long id;
    String type;
    int floor;
    boolean isBooked;
    int price;
}
