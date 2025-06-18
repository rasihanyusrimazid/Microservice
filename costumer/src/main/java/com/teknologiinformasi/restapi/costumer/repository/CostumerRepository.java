package com.teknologiinformasi.restapi.costumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasi.restapi.costumer.model.Costumer;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
}