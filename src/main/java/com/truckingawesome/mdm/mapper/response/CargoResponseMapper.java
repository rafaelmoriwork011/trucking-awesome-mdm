package com.truckingawesome.mdm.mapper.response;

import com.truckingawesome.mdm.domain.Cargo;
import com.truckingawesome.mdm.dto.response.CargoResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CargoResponseMapper {
    CargoResponseDto toDTO(Cargo cargo);

    List<CargoResponseDto> toDTOList(List<Cargo> cargos);
}
