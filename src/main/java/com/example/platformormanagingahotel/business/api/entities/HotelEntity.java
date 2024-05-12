package com.example.platformormanagingahotel.business.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JsonProperty("name")
    String name;
    int numOfStars;
    @JsonProperty("address")
    String address;
    @JsonProperty("billingInfo")
    String billingInfo;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "hotel")
    List<Room> room;

}
