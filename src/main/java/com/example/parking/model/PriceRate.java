package com.example.parking.model;

import com.example.parking.enumaration.PriceRateType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceRate extends BaseEntity {


    private PriceRateType priceRateType;

    private Double price;

    @OneToMany(mappedBy = "priceRate",cascade = CascadeType.REMOVE)
    private Set<Parking> parking = new LinkedHashSet<>();
}
