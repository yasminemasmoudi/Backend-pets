package com.pets.pets_service.Models;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

import javax.persistence.*;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float price;
    private boolean inStock;
    @Enumerated(EnumType.STRING)
    private ProductType productType;


    @ManyToOne
    private ProductProvider productProviders;    
}
