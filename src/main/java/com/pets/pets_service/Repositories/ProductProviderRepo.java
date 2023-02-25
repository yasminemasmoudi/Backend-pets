package com.pets.pets_service.Repositories;

import com.pets.pets_service.Models.ProductProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200/")
@Repository
public interface ProductProviderRepo extends JpaRepository<ProductProvider,Integer> {
}
