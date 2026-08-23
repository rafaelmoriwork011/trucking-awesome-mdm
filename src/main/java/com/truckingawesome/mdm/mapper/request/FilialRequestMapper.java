package com.truckingawesome.mdm.mapper.request;

import com.truckingawesome.mdm.domain.Filial;
import com.truckingawesome.mdm.dto.request.FilialRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FilialRequestMapper {

    @Mapping(target = "id", ignore = true)
    Filial toEntity(FilialRequestDto filialRequestDto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(FilialRequestDto dto, @MappingTarget Filial filial);
}
