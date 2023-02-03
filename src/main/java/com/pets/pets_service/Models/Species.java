package com.pets.pets_service.Models;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "specie_id")
    private Integer id;
    private String type;

    @OneToOne(mappedBy = "species")
    private Pet pet;

}
