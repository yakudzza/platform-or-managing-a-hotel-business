package com.example.platformormanagingahotel.business.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    String type;
    int floor;
    int roomNum;
    int cost;
    boolean isBooked;
    int price;
    @OneToOne
    UserEntity user;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    HotelEntity hotel;
    Long imageId;
}

