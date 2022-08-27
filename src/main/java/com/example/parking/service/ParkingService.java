package com.example.parking.service;

import com.example.parking.model.Parking;
import com.example.parking.service.base.BaseService;

import java.util.List;

public interface ParkingService extends BaseService<Parking,Long> {

 List<Parking> findAllByVehicleId(Long id);
 List<Parking> findAllByVehicleNumber(String carNumber);
 Long showTotalTicket(Long id);

 void pay(Long id);

 void exitVehicle(Long id);

}
