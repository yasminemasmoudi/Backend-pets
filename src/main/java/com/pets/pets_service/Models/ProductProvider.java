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
public class ProductProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;
    private String email;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "productProviders")
    private List<Product> products;
}
