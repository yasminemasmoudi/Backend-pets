package com.pets.pets_service.Repositories;


import com.pets.pets_service.Models.Species;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.validation.Valid;

@Repository
public interface SpeciesRepo extends JpaRepository<Species,Integer> {
}
