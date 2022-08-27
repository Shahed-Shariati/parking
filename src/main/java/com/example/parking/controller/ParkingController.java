package com.example.parking.controller;

import com.example.parking.dto.ParkingDto;
import com.example.parking.mapper.ParkingMapper;
import com.example.parking.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parking/")
@AllArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper mapper;

    @PostMapping("save")
    public ResponseEntity<ParkingDto> save(@RequestBody ParkingDto parkingDto){
        var parking = mapper.toParking(parkingDto);
        parkingService.save(parking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<ParkingDto>> findAll(){
        var parkingList = parkingService.findAll();
        var parkingDto = mapper.toParkingDtoList(parkingList);
        return ResponseEntity.ok(parkingDto);
    }

    @DeleteMapping("delete/{id}")
    public  ResponseEntity<String> deleteById(@PathVariable Long id)
    {
        var parking = parkingService.findById(id).get();
        parkingService.delete(parking);
        return ResponseEntity.ok("ok");

    }


    @GetMapping("findAllByVehicle/{id}")
    public ResponseEntity<List<ParkingDto>> findAllByVehicle(@PathVariable Long id){
        var parkings = parkingService.findAllByVehicleId(id);
        var result = mapper.toParkingDtoList(parkings);
        return ResponseEntity.status(HttpStatus.FOUND).body(result);
    }


    @GetMapping("showTotalTicket/{id}")
    public ResponseEntity<Long> submit(@PathVariable Long id){
        var result = parkingService.showTotalTicket(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    @PutMapping("pay/{id}")
    public ResponseEntity<String> pay(@PathVariable Long id){
        parkingService.pay(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Pay");
    }

    @PutMapping("exitVehicle/{id}")
    public ResponseEntity<String> exitVehicle(@PathVariable Long id){
        parkingService.exitVehicle(id);
        return ResponseEntity.ok("Exit vehicle");
    }
}
