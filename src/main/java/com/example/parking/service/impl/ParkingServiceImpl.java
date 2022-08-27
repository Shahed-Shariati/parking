package com.example.parking.service.impl;

import com.example.parking.exception.NotFoundException;
import com.example.parking.model.Parking;
import com.example.parking.repository.ParkingRepository;
import com.example.parking.service.ParkingService;
import com.example.parking.service.PriceRateService;
import com.example.parking.service.VehicleService;
import com.example.parking.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ParkingServiceImpl extends BaseServiceImpl<ParkingRepository, Parking,Long> implements ParkingService {

    private final VehicleService vehicleService;
    private final PriceRateService priceRateService;
    public ParkingServiceImpl(ParkingRepository repository, VehicleService vehicleService, PriceRateService priceRateService) {
        super(repository);
        this.vehicleService = vehicleService;
        this.priceRateService = priceRateService;
    }


    @Override
    @Transactional
    public void save(Parking parking) {
        var vehicle = vehicleService.findById(parking.getVehicle().getId());
        var priceRate = priceRateService.findById(parking.getPriceRate().getId());
        parking.setVehicle(vehicle.get());
        parking.setExitVehicleDate(null);
        parking.setPriceRate(priceRate.get());
        parking.setIsPay(false);
        super.save(parking);
    }

    @Override
    public List<Parking> findAllByVehicleId(Long id) {
        return repository.findAllByVehicle_Id(id);
    }

    @Override
    public List<Parking> findAllByVehicleNumber(String carNumber) {
        return repository.findAllByVehicle_CarNumber(carNumber);
    }

    @Override
    public Long showTotalTicket(Long id) {
        var parking = repository.findParkingByVehicle_Id(id).orElseThrow(() ->
            new NotFoundException("")
        );
        Long result = computingTiket(parking).longValue();
        return result;
    }

    @Override
    public void pay(Long id) {
        var parking = repository.findParkingByVehicle_Id(id).orElseThrow(() ->
                new NotFoundException("")
        );
        parking.setIsPay(true);
        super.save(parking);
    }

    @Override
    public void exitVehicle(Long id) {
       var parking = super.findById(id).get();
       parking.setExitVehicleDate(new Date());
       super.save(parking);
    }


    private Double computingTiket(Parking parking){
        LocalDateTime enterDate = LocalDateTime.ofInstant(parking.getEnterVehicleDate().toInstant(), ZoneId.systemDefault());
        LocalDateTime nowDate = LocalDateTime.now();
        Duration duration = Duration.between(enterDate,nowDate);

        return duration.toHours() * parking.getPriceRate().getPrice();

       /* if (parking.getPriceRate().getPriceRateType() == PriceRateType.DAYiLY){
            return  (duration.toHours() * parking.getPriceRate().getPrice());
        }else if (parking.getPriceRate().getPriceRateType() == PriceRateType.MONTHLY){
              return (duration.toHours() * parking.getPriceRate().getPrice());
        }if (parking.getPriceRate().getPriceRateType() == PriceRateType.YEARLY){
            return (duration.toHours() * parking.getPriceRate().getPrice());
        }*/

    }
}
