package com.example.platformormanagingahotel.business.api.services;

import com.example.platformormanagingahotel.business.api.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;
}
