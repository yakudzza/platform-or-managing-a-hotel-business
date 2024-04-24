package com.example.platformormanagingahotel.business.api.entities.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    CLIENT,
    STAFF;

    @Override
    public String getAuthority() {
        return name();
    }
}
