package com.example.platformormanagingahotel.business.api.repositories;


import com.example.platformormanagingahotel.business.api.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

   Optional<UserEntity> findByEmail(String email);

   boolean existsByEmail(String email);

   Optional<UserEntity> findById(Long id);

   boolean existsById(Long id);
}
