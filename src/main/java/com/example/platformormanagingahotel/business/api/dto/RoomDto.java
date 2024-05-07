package com.example.platformormanagingahotel.business.api.dto;

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
}
