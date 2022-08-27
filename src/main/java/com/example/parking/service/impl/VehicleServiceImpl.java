package com.example.parking.service.impl;

import com.example.parking.model.Vehicle;
import com.example.parking.repository.VehicleRepository;
import com.example.parking.service.VehicleService;
import com.example.parking.service.base.BaseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl extends BaseServiceImpl<VehicleRepository, Vehicle,Long> implements VehicleService {


    public VehicleServiceImpl(VehicleRepository repository) {
        super(repository);
    }

}
