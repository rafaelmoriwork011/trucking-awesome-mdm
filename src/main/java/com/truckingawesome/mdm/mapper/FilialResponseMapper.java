package com.truckingawesome.mdm.mapper;

import com.truckingawesome.mdm.domain.Filial;
import com.truckingawesome.mdm.dto.response.FilialResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilialResponseMapper {
    FilialResponseDto toDTO(Filial filial);

    List<FilialResponseDto> toDTOList(List<Filial> filiais);
}
