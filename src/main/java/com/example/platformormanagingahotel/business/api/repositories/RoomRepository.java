package com.example.platformormanagingahotel.business.api.repositories;

import com.example.platformormanagingahotel.business.api.dto.RoomDto;
import com.example.platformormanagingahotel.business.api.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
