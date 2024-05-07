package com.example.platformormanagingahotel.business.api.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
