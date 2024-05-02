package com.example.platformormanagingahotel.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.platformormanagingahotel.business.api.entities"})
public class PlatformOrManagingAHotelBusinessApplication {


	public static void main(String[] args) {
		SpringApplication.run(PlatformOrManagingAHotelBusinessApplication.class, args);
	}

}
