package com.example.parking.repository;

import com.example.parking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingRepository extends JpaRepository<Parking,Long> {

    List<Parking> findAllByVehicle_Id(Long id);
    Optional<Parking> findParkingByVehicle_Id(Long id);

    List<Parking> findAllByVehicle_CarNumber(String carNumber);
}
