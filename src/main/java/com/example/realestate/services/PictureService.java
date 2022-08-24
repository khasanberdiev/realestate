package com.example.realestate.services;

import com.example.realestate.models.Picture;

import java.util.List;


public interface PictureService {

    List<Picture> getAllPictures();
    void saveAllPictureList(List<Picture> pictureList);
    List<Picture> findPictureByPropertyId(Long id);
  
   
}
