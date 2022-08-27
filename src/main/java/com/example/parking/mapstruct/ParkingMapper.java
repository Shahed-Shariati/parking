package com.example.parking.mapstruct;

import com.example.parking.dto.ParkingDto;
import com.example.parking.model.Parking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring",uses = {VehicleMapper.class,PriceRateMapper.class})
public interface ParkingMapper {


    @Mappings({
            @Mapping(source = "enterVehicleDate", target = "enterVehicleDate", qualifiedByName = "TimestampToDate", ignore = false),
            @Mapping(source = "exitVehicleDate", target = "exitVehicleDate", qualifiedByName = "TimestampToDate", ignore = false)
    })
    Parking toParking(ParkingDto parkingDto);

    @Mappings({
            @Mapping(source = "enterVehicleDate", target = "enterVehicleDate", qualifiedByName = "DateToTimestamp", ignore = false),
            @Mapping(source = "exitVehicleDate", target = "exitVehicleDate", qualifiedByName = "DateToTimestamp", ignore = false)
    })
    ParkingDto toParkingDto(Parking parking);

    List<Parking> toParkingList(List<ParkingDto> parkingDtos);

    List<ParkingDto> toParkingDtoList(List<Parking> parkings);

    @Named("TimestampToDate")
    default Date toDate(Long timeStamp){
        if(timeStamp != null)
            return new Date(timeStamp);
        return null;
    }

    @Named("DateToTimestamp")
    default Long toTimeStamp (Date date){
        if(date != null)
            return date.getTime();
        return null;
    }
}
