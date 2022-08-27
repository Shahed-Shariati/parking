package com.example.parking.dto;

import com.example.parking.enumaration.VehicleType;
import lombok.Data;

import javax.persistence.Column;

@Data
public class VehicleDto extends BaseDto {

    private String color;

    private String carNumber;

    private VehicleType vehicleType;
}
