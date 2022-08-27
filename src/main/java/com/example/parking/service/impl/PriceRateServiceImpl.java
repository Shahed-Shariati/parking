package com.example.parking.service.impl;

import com.example.parking.model.PriceRate;
import com.example.parking.repository.PriceRateRepository;
import com.example.parking.service.PriceRateService;
import com.example.parking.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PriceRateServiceImpl extends BaseServiceImpl<PriceRateRepository, PriceRate,Long> implements PriceRateService {

    public PriceRateServiceImpl(PriceRateRepository repository) {
        super(repository);
    }

}
