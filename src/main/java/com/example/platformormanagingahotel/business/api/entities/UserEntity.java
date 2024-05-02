package com.example.platformormanagingahotel.business.api.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    @Column(unique = true, updatable = false)
    private String email;

    private String phoneNumber;

    private String password;

    private LocalDate dateOfBirth;

    @Column(unique = true, updatable = false)
    private String passportSeries;

    @Column(unique = true, updatable = false)
    private String passportNumber;

    private String citizenship;

    @Builder.Default
    private Instant createdAt = Instant.now();

    @ManyToMany
    @JoinTable(
            name = "roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<RoleEntity> roles;


    private boolean active;



}
