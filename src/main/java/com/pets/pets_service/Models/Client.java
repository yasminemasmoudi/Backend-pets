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

public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fullName;
    private String email;
    private String address;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Pet> pets;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Appointment> appointments;
}
