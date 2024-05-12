package com.example.platformormanagingahotel.business.api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {

    Long id;
    String name;
    int numOfStars;
    String address;
    String billingInfo;
}
