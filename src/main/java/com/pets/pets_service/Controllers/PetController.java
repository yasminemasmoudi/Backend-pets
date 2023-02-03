package com.pets.pets_service.Controllers;

import com.pets.pets_service.Models.Pet;
import com.pets.pets_service.Repositories.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class PetController {
    @Autowired
    private PetRepo petRepo ;

    @PostMapping("/pets")
    public Pet createAccount(@Valid @RequestBody Pet pet) {
        return petRepo.save(pet);
    }
}
