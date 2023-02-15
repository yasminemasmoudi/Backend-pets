package com.pets.pets_service.Models;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class ProductProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String fullName;
    private String email;
    private String address;
    private String phone;
    private String ProductType;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "provider_id", referencedColumnName = "id")
private List<Product> products;
}
