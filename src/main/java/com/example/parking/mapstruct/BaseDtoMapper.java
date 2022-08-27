package com.example.parking.mapstruct;

import com.example.parking.dto.BaseDto;
import com.example.parking.model.BaseEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BaseDtoMapper {

    BaseDto toBaseDto(BaseEntity baseEntity);
    BaseEntity toBaseEntity(BaseDto baseDto);

    List<BaseDto> toBaseDtoList(List<BaseEntity> baseEntities);
    List<BaseEntity> toBaseEntityList(List<BaseDto> baseDtos);
}
