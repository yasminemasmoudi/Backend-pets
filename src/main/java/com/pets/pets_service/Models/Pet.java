package com.pets.pets_service.Models;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String sex;
    private String age;
    private String furColor;
    private String arrivalTime;
    private String img_url;
    private boolean forAdoption;
    @Enumerated(EnumType.STRING)
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;



}

