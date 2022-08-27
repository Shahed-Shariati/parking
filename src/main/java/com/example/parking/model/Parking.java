package com.example.parking.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.stat.CacheableDataStatistics;

import javax.persistence.*;
import java.util.Date;

@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parking extends BaseEntity {

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date enterVehicleDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date exitVehicleDate;

    @ManyToOne()
    @JoinColumn(name = "vehicle_id",insertable = true)
   // @JoinColumn(name = "vehicle_id",insertable = false,updatable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "price_rate_id")
    private PriceRate priceRate;

    private Boolean isPay;


}
