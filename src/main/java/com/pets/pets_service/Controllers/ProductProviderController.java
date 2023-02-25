package com.pets.pets_service.Controllers;
import com.pets.pets_service.Exception.ResourceNotFoundException;
import com.pets.pets_service.Models.ProductProvider;
import com.pets.pets_service.Repositories.ProductProviderRepo;
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
public class ProductProviderController {

    @Autowired
    private ProductProviderRepo productProviderRepo;

    @GetMapping("/productProviders")
    public List<ProductProvider> getAllProductProviders() {
        return productProviderRepo.findAll();
    }
    @GetMapping("/productProviders/{id}")
    public ResponseEntity<ProductProvider> getProductProviderById(@PathVariable(value = "id") Integer productProviderId)
            throws ResourceNotFoundException {

        ProductProvider productProvider = productProviderRepo.findById(productProviderId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Provider not found"));
        return ResponseEntity.ok().body(productProvider);
    }

    @PostMapping("/productProviders")
    public ProductProvider createProductProvider(@Valid @RequestBody  ProductProvider productProvider) {
        return productProviderRepo.save(productProvider);
    }

    @PutMapping("/productProviders/{id}")
    public ResponseEntity<ProductProvider> updateProductProvider(@PathVariable(value = "id") Integer ProductProviderId,
                                               @Valid @RequestBody ProductProvider productProviderDetails) throws ResourceNotFoundException {
        ProductProvider productProvider = productProviderRepo.findById(ProductProviderId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        productProvider.setProduct(productProviderDetails.getProduct());
        productProvider.setId(productProviderDetails.getId());
        productProvider.setEmail(productProviderDetails.getEmail());
        productProvider.setAddress(productProviderDetails.getAddress());
        productProvider.setPhone(productProviderDetails.getPhone());
        productProvider.setFullName(productProviderDetails.getFullName());

        final ProductProvider updatedProductProvider = productProviderRepo.save(productProvider);
        return ResponseEntity.ok(updatedProductProvider);
    }

    @DeleteMapping("/clients/{id}")
    public Map<String, Boolean> deleteProductProviderAccount(@PathVariable(value = "id") Integer productProviderId)
            throws ResourceNotFoundException {
        ProductProvider productProvider = productProviderRepo.findById(productProviderId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Provider not found"));
        productProviderRepo.delete(productProvider);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
