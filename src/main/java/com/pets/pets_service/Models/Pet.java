package com.pets.pets_service.Models;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pet")
@DynamicUpdate
@DynamicInsert
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String sex;
    private String age;
    private String furColor;
    private String weight;
    private String length;
    private String arrivalTime;
    private boolean forAdoption;
}
