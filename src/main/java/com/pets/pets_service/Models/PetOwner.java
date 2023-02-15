package com.pets.pets_service.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor

public class PetOwner{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String email;
    private String address;
    private String phone;
    
    @OneToMany(mappedBy = "petOwner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pet> pets;
}
