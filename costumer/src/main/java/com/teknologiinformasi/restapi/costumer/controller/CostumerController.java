package com.teknologiinformasi.restapi.costumer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teknologiinformasi.restapi.costumer.model.Costumer;
import com.teknologiinformasi.restapi.costumer.service.CostumerService;

@RestController
@RequestMapping("/api/costumer")
public class CostumerController {


   @Autowired
   private CostumerService costumerService;


   // Endpoint untuk mengambil semua produk
   @GetMapping
   public List<Costumer> getAllCostumer() {
       return costumerService.getAllCostumer();
   }


   // Endpoint untuk mengambil produk berdasarkan id
   @GetMapping("/{id}")
   public ResponseEntity<Costumer> getCostumerById(@PathVariable Long id) {
       return costumerService.getCostumerById(id)
               .map(costumer -> ResponseEntity.ok().body(costumer))
               .orElse(ResponseEntity.notFound().build());
   }


   // Endpoint untuk membuat produk baru
   @PostMapping
   public Costumer createCostumer(@RequestBody Costumer costumer) {
       return costumerService.createCostumer(costumer);
   }


   // Endpoint untuk mengupdate produk yang sudah ada
   @PutMapping("/{id}")
   public ResponseEntity<Costumer> updateCostumer(@PathVariable Long id, @RequestBody Costumer costumerDetails) {
       try {
           Costumer updatedCostumer = costumerService.updateCostumer(id, costumerDetails);
           return ResponseEntity.ok(updatedCostumer);
       } catch (RuntimeException e) {
           return ResponseEntity.notFound().build();
       }
   }


   // Endpoint untuk menghapus produk
  @DeleteMapping("/{id}")
public ResponseEntity<Map<String, String>> deleteCostumer(@PathVariable Long id) {
   try {
       costumerService.deleteCostumer(id);
       Map<String, String> response = new HashMap<>();
       response.put("message", "Produk berhasil dihapus");
       return ResponseEntity.ok(response);
   } catch (RuntimeException e) {
       Map<String, String> response = new HashMap<>();
       response.put("message", "Produk tidak ditemukan dengan id " + id);
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
   }
}
}