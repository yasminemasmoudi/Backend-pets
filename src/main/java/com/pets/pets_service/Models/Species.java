package com.pets.pets_service.Models;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "species_id")
    private Integer id;
    private String type;

    @OneToMany(mappedBy = "species", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pet> pets;

}
