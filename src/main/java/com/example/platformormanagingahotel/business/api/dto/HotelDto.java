package com.example.platformormanagingahotel.business.api.dto;


import com.example.platformormanagingahotel.business.api.entities.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {
    Long id;
    String name;
    String description;
    int numOfStars;
    String address;
    String billingInfo;
}
