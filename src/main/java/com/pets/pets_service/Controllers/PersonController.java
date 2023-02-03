package com.pets.pets_service.Controllers;
import com.pets.pets_service.Exception.ResourceNotFoundException;
import com.pets.pets_service.Models.Person;
import com.pets.pets_service.Repositories.PersonRepo;
import com.pets.pets_service.Repositories.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v3")
public class PersonController {
    @Autowired
    private PersonRepo personRepo ;

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personRepo.findAll();
    }
    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Integer personId)
            throws ResourceNotFoundException {

        Person person = personRepo.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        return ResponseEntity.ok().body(person);
    }
    @PostMapping("/pets")
    public Person createPerson(@Valid @RequestBody Person person) {
        return personRepo.save(person);
    }
    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Integer personId,
                                         @Valid @RequestBody Person personDetails) throws ResourceNotFoundException {
        Person person = personRepo.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        person.setFullName(personDetails.getFullName());
        person.setEmail(personDetails.getEmail());
        person.setAddress(personDetails.getAddress());
        person.setPhone(personDetails.getPhone());

        final Person updatedPerson = personRepo.save(person);
        return ResponseEntity.ok(updatedPerson);
    }
    @DeleteMapping("/persons/{id}")
    public Map<String, Boolean> deleteAccount(@PathVariable(value = "id") Integer personId)
            throws ResourceNotFoundException {
        Person person = personRepo.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        personRepo.delete(person);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
