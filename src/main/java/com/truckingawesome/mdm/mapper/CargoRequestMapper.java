package com.truckingawesome.mdm.mapper;

import com.truckingawesome.mdm.domain.Cargo;
import com.truckingawesome.mdm.dto.request.CargoRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CargoRequestMapper {

    Cargo toEntity(CargoRequestDto cargoDTO);

    void updateEntityFromDTO(CargoRequestDto dto, @MappingTarget Cargo cargo);
}
