package com.example.parking.model;

import com.example.parking.enumaration.VehicleType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle extends BaseEntity {

     private String color;

     @Column(unique = true)
     private String carNumber;

     private VehicleType vehicleType;

     @OneToMany(mappedBy = "vehicle" ,cascade = CascadeType.REMOVE)
     private Set<Parking> parking = new LinkedHashSet<>();


}
