package com.example.ProjectY.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//ITEM ENTITY
@Entity
@Table(name ="ItemData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String imageUrl;
    private String sellerName;
    private int price;
    private String adress;
    private String caption;
    private String description;
    private String sellerPhone;
}
