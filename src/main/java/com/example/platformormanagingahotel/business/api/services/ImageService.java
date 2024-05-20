package com.example.platformormanagingahotel.business.api.services;

import com.example.platformormanagingahotel.business.api.entities.Image;
import com.example.platformormanagingahotel.business.api.repositories.ImageRepository;
import com.example.platformormanagingahotel.business.api.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    public Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(ImageUtils.compressImage(file.getBytes()));
        return image;
    }
}
