package com.teknologiinformasi.restapi.costumer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknologiinformasi.restapi.costumer.model.Costumer;
import com.teknologiinformasi.restapi.costumer.repository.CostumerRepository;

@Service
public class CostumerService {
    
    @Autowired
    private CostumerRepository costumerRepository;
    
    public List<Costumer> getAllCostumer() {
        return costumerRepository.findAll();
    }
    
    public Optional<Costumer> getCostumerById(Long id) {
        return costumerRepository.findById(id);
    }
    
    public Costumer createCostumer(Costumer costumer) {
        return costumerRepository.save(costumer);
    }
    
    public Costumer updateCostumer(Long id, Costumer costumerDetails) {
        Costumer costumer = costumerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produk not found with id: " + id));
            
        costumer.setName(costumerDetails.getName());
        costumer.setEmail(costumerDetails.getEmail());
        
        return costumerRepository.save(costumer);
    }
    
    public void deleteCostumer(Long id) {
        Costumer costumer = costumerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produk not found with id: " + id));
            
        costumerRepository.delete(costumer);
    }
}