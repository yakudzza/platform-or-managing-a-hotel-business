package com.example.platformormanagingahotel.business.api.repositories;

import com.example.platformormanagingahotel.business.api.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}