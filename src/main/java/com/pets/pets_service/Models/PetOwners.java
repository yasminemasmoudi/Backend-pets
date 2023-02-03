package com.pets.pets_service.Models;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "pet_owners")
public class PetOwners {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(mappedBy = "pet_owner" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Pets> pets;
}
