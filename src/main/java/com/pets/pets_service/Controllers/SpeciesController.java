package com.pets.pets_service.Controllers;

import com.pets.pets_service.Models.Species;
import com.pets.pets_service.Repositories.SpeciesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class SpeciesController {
    @Autowired
    private SpeciesRepo speciesRepo ;

    @PostMapping("/species")
    public Species createSpecies(@Valid @RequestBody Species species) {
        return speciesRepo.save(species);
    }
}
