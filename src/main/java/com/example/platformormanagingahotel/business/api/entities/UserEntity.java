package com.example.platformormanagingahotel.business.api.entities;


import com.example.platformormanagingahotel.business.api.entities.enums.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {
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

    //гражданство
    private String citizenship;

    @Builder.Default
    private Instant createdAt = Instant.now();
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles = new HashSet<>();
    private boolean active;



    //Security
    public boolean isAdmin() {
        return roles.contains(Roles.ROLE_ADMIN);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
