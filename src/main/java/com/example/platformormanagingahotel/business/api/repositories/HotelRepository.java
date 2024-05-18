package com.example.platformormanagingahotel.business.api.repositories;

import com.example.platformormanagingahotel.business.api.entities.HotelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends CrudRepository<HotelEntity, Long> {

}
