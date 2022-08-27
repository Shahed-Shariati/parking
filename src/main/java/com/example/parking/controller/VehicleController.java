package com.example.parking.controller;


import com.example.parking.dto.VehicleDto;
import com.example.parking.mapper.VehicleMapper;
import com.example.parking.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicle/")
@AllArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;
    private VehicleMapper mapper;
    @PostMapping("save")
    public ResponseEntity<VehicleDto> save(@RequestBody VehicleDto vehicleDto){
        var vehicle = mapper.toVehicle(vehicleDto);
        vehicleService.save(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<VehicleDto>> findAll(){
       var vehicles =    vehicleService.findAll();
       var result = mapper.toVehicleDtoList(vehicles);
       return ResponseEntity.ok(result);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id)
    {
        var vehicle =vehicleService.findById(id).get();
        vehicleService.delete(vehicle);
        return ResponseEntity.ok().build();
    }
}
