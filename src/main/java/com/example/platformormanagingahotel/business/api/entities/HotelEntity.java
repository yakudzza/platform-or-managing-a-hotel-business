package com.example.platformormanagingahotel.business.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    String description;
    int numOfStars;

    @JsonProperty("address")
    String address;

    @JsonProperty("billingInfo")
    String billingInfo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "hotel")
    List<Room> room;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.EAGER)
    List<Image> images = new ArrayList<>();

    Long previewImageId;

    public void addImage(Image image) {
        images.add(image);
        image.setHotel(this);
    }
}

