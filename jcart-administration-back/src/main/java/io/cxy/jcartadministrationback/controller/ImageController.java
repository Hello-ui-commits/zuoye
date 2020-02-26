package io.cxy.jcartadministrationback.controller;

import io.cxy.jcartadministrationback.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile multipartFile){


        return  imageService.upload(multipartFile);
    }
}
