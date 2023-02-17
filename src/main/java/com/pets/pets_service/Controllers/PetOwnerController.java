package com.pets.pets_service.Controllers;
import com.pets.pets_service.Exception.ResourceNotFoundException;
import com.pets.pets_service.Models.PetOwner;
import com.pets.pets_service.Repositories.PetOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class PetOwnerController {
    @Autowired
    private PetOwnerRepo petOwnerRepo;

    @GetMapping("/petOwners")
    public List<PetOwner> getAllPetOwners (@PathVariable(value = "id") Integer petOwnerId)
            throws ResourceNotFoundException {

        PetOwner petOwner = petOwnerRepo.findById(petOwnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Pet Owner not found"));
        return (List<PetOwner>) ResponseEntity.ok().body(petOwner);
    }
    @PostMapping("/petOwners")
    public PetOwner createPetOwner(@Valid @RequestBody PetOwner petOwner) {
        return PetOwnerRepo.save(petOwner);
    }

    @PutMapping("/petOwners/{id}")
    public ResponseEntity<PetOwner> updatePetOwner(@PathVariable(value = "id") Integer petOwnerId,
                                               @Valid @RequestBody PetOwner petOwnerDetails) throws ResourceNotFoundException {
        PetOwner petOwner = PetOwnerRepo.findById(petOwnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Pet Owner not found"));
        petOwner.setId(petOwnerDetails.getId());
        petOwner.setPets(petOwnerDetails.getPets());
        petOwner.setFullName(petOwnerDetails.getFullName());
        petOwner.setEmail(petOwner.getEmail());
        petOwner.setAddress(petOwner.getAddress());
        petOwner.setPhone(petOwner.getPhone());
        petOwner.setAppointments(petOwnerDetails.getAppointments());
        petOwner.setProducts(petOwnerDetails.getProducts());

        final PetOwner updatedPetOwner = petOwnerRepo.save(petOwner);
        return ResponseEntity.ok(updatedPetOwner);
    }

    @DeleteMapping("/clients/{id}")
    public Map<String, Boolean> deleteClientAccount(@PathVariable(value = "id") Integer petOwnerId)
            throws ResourceNotFoundException {
        PetOwner petOwner = petOwnerRepo.findById(petOwnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Pet Owner not found"));
        petOwnerRepo.delete(petOwner);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
