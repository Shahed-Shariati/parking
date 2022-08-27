package com.example.parking.repository;

import com.example.parking.model.PriceRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRateRepository extends JpaRepository<PriceRate,Long> {
}
