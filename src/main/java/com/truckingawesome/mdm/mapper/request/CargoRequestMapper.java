package com.truckingawesome.mdm.mapper.request;

import com.truckingawesome.mdm.domain.Cargo;
import com.truckingawesome.mdm.dto.request.CargoRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CargoRequestMapper {

    @Mapping(target = "id", ignore = true)
    Cargo toEntity(CargoRequestDto cargoDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(CargoRequestDto dto, @MappingTarget Cargo cargo);
}
