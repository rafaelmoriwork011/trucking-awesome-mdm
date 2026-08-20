package com.truckingawesome.mdm.mapper;

import com.truckingawesome.mdm.domain.Filial;
import com.truckingawesome.mdm.dto.request.FilialRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FilialRequestMapper {
    Filial toEntity(FilialRequestDto filialRequestDto);

    void updateEntityFromDTO(FilialRequestDto dto, @MappingTarget Filial filial);
}
