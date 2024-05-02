package com.example.platformormanagingahotel.business.api.entities.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_STAFF;

    @Override
    public String getAuthority() {
        return name();
    }
}
