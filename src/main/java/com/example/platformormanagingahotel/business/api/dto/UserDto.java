package com.example.platformormanagingahotel.business.api.dto;


import com.example.platformormanagingahotel.business.api.entities.enums.Roles;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.class)
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private LocalDate dateOfBirth;
    private String passportSeries;
    private String passportNumber;
    private String citizenship;
    private boolean isActive;
    private Set<Roles> roles;
}
