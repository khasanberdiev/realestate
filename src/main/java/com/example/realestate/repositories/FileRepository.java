package com.example.realestate.repositories;

import com.example.realestate.models.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<Picture, Long> {

    List<Picture> findByPropertyId(Long id);
    
}
