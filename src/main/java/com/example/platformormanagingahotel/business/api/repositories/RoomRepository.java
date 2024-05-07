package com.example.platformormanagingahotel.business.api.repositories;

import com.example.platformormanagingahotel.business.api.dto.RoomDto;
import com.example.platformormanagingahotel.business.api.entities.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
