package com.example.parking.mapper;

import com.example.parking.dto.PriceRateDto;
import com.example.parking.model.PriceRate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = BaseDtoMapper.class)
public interface PriceRateMapper {

    PriceRate toPriceRate(PriceRateDto priceRateDto);

    PriceRateDto toPriceRateDto(PriceRate priceRate);

    List<PriceRate> toPriceRateList(List<PriceRateDto> priceRateDtos);

    List<PriceRateDto> toPriceRateDtoList(List<PriceRate> priceRates);
}
