package com.example.ProjectY.repository;

import com.example.ProjectY.models.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//IMAGE REPOSITORY
public interface StorageRepository extends JpaRepository<ImageData,Integer> {


    Optional<ImageData> findByName(String fileName);
}
