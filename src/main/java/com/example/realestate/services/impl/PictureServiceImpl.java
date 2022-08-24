package com.example.realestate.services.impl;

import com.example.realestate.models.Picture;
import com.example.realestate.repositories.FileRepository;
import com.example.realestate.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public List<Picture> getAllPictures() {
        List<Picture> getAllPictures=fileRepository.findAll();
        return (List<Picture>)getAllPictures;
    }

    

    @Override
    public void saveAllPictureList(List<Picture> pictureList) {
        for(Picture picture:pictureList){
            fileRepository.save(picture);
        }
        
    }
    


    @Override
    public List<Picture> findPictureByPropertyId(Long id) {
        List<Picture> picture=fileRepository.findByPropertyId(id);
        return picture;
    }


    
}
