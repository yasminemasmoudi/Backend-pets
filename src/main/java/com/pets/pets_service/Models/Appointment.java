package com.pets.pets_service.Models;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.sql.Time;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Date date;
    private Time time;
    private String description;

    @ManyToOne
    private PetOwner petOwner;

    @ManyToOne
    private Veterinary veterinary;

}
