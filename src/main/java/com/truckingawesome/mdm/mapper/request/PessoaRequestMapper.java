package com.truckingawesome.mdm.mapper.request;

import com.truckingawesome.mdm.domain.Pessoa;
import com.truckingawesome.mdm.dto.request.PessoaRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PessoaRequestMapper {

    @Mapping(target = "id", ignore = true)
    Pessoa toEntity(PessoaRequestDto dto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(PessoaRequestDto dto, @MappingTarget Pessoa entity);
}
