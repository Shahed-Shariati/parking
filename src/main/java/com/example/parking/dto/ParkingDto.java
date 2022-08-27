package com.example.parking.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ParkingDto extends BaseDto{

    @ApiModelProperty(required = true,hidden = false)
    private long enterVehicleDate;

    @ApiModelProperty(required = true,hidden = false)
    private long exitVehicleDate;

    @ApiModelProperty(required = true,hidden = false)
    private VehicleDto vehicle;

    @ApiModelProperty(required = true,hidden = false)
    private PriceRateDto priceRate;

    @ApiModelProperty(required = true,hidden = true)
    private Boolean isPay;
}
