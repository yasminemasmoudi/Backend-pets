package com.pets.pets_service.Models;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class ProductProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String email;
    private String address;
    private String phone;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
