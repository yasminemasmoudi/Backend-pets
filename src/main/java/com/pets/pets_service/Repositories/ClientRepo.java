package com.pets.pets_service.Repositories;

import com.pets.pets_service.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200/")
@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {
}
