package com.example.parking.controller;

import com.example.parking.dto.PriceRateDto;
import com.example.parking.mapstruct.PriceRateMapper;
import com.example.parking.service.PriceRateService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pricerate/")
@AllArgsConstructor

public class PriceRateController {

    private final PriceRateService priceRateService;
    private final PriceRateMapper mapper;

    @PostMapping("save")
    public ResponseEntity<String> save(@RequestBody PriceRateDto priceRateDto){

        var priceRate = mapper.toPriceRate(priceRateDto);
        priceRateService.save(priceRate);
        return ResponseEntity.status(HttpStatus.CREATED).body("ok");
    }

    @GetMapping("findAll")
    public ResponseEntity<List<PriceRateDto>> findAll()
    {
        var priceRateList = priceRateService.findAll();
        var result = mapper.toPriceRateDtoList(priceRateList);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteById(@RequestBody PriceRateDto priceRateDto){
        var priceRate = mapper.toPriceRate(priceRateDto);
        priceRateService.delete(priceRate);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("ok");

    }
}
