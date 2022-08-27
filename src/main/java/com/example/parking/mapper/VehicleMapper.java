package com.example.parking.mapper;


import com.example.parking.dto.VehicleDto;
import com.example.parking.model.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = BaseDtoMapper.class)
public interface VehicleMapper {

    Vehicle toVehicle(VehicleDto vehicleDto);

    VehicleDto toVehicleDto(Vehicle vehicle);

    List<Vehicle> toVehicleList(List<VehicleDto> vehicleDtos);

    List<VehicleDto> toVehicleDtoList(List<Vehicle> vehicles);
}
