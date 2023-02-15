package com.pets.pets_service.Controllers;

import com.pets.pets_service.Exception.ResourceNotFoundException;
import com.pets.pets_service.Models.Species;
import com.pets.pets_service.Repositories.SpeciesRepo;
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
public class SpeciesController {
    @Autowired
    private SpeciesRepo speciesRepo ;

    @GetMapping("/species")
    public List<Species> getAllSpecies(){
        return speciesRepo.findAll();
    }
    @GetMapping("species/{id}")
    public ResponseEntity<Species> getSpeciesById(@PathVariable(value = "id") Integer speciesId)
            throws ResourceNotFoundException {

        Species species = speciesRepo.findById(speciesId)
                .orElseThrow(() -> new ResourceNotFoundException("Species not found"));
        return ResponseEntity.ok().body(species);
    }
    @PostMapping("/species")
    public Species createSpecies(@Valid @RequestBody Species species) {
        return speciesRepo.save(species);
    }
    @PutMapping("/species/{id}")
    public ResponseEntity<Species> updateSpecies(@PathVariable(value = "id") Integer speciesId,
                                               @Valid @RequestBody Species speciesDetails) throws ResourceNotFoundException {
        Species species = speciesRepo.findById(speciesId)
                .orElseThrow(() -> new ResourceNotFoundException("species not found"));
        species.setType(speciesDetails.getType());

        final Species updatedSpecies = speciesRepo.save(species);
        return ResponseEntity.ok(updatedSpecies);
    }
    @DeleteMapping("/species/{id}")
    public Map<String, Boolean> deleteAccount(@PathVariable(value = "id") Integer speciesId)
            throws ResourceNotFoundException {
        Species species = speciesRepo.findById(speciesId)
                .orElseThrow(() -> new ResourceNotFoundException("Species not found"));
        speciesRepo.delete(species);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
