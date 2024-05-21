package com.example.platformormanagingahotel.business.api.dto;

import com.example.platformormanagingahotel.business.api.entities.HotelEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    Long id;
    String name;
    String description;
    String type;
    int floor;
    int roomNum;
    int cost;
    boolean isBooked;
    int price;
}
