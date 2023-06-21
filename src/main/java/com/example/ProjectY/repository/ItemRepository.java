package com.example.ProjectY.repository;

import com.example.ProjectY.models.ItemData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//ITEM REPOSITORY
@Repository
public interface ItemRepository extends JpaRepository<ItemData,Integer> {
}
