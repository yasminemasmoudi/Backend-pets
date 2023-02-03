package com.pets.pets_service.Models;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String fullName;
    private String email;
    private String address;
    private String phone;
}
