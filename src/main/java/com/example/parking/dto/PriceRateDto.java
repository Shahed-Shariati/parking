package com.example.parking.dto;

import com.example.parking.enumaration.PriceRateType;
import lombok.Data;

@Data
public class PriceRateDto extends BaseDto{

    private PriceRateType priceRateType;

    private Double price;
}
