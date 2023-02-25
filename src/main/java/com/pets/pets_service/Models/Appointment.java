package com.pets.pets_service.Models;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

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
    private Client client;

    @ManyToOne
    @JoinColumn(name = "veterinary_id")
    private Veterinary veterinary;
}
