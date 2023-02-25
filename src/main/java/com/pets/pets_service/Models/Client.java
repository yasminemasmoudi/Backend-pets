package com.pets.pets_service.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor

public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String email;
    private String address;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private List<Pet> pets;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private List<Appointment> appointments;
}
