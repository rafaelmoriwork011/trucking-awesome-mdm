package com.truckingawesome.mdm.mapper.request;

import com.truckingawesome.mdm.domain.Pessoa;
import com.truckingawesome.mdm.dto.request.PessoaRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PessoaRequestMapper {
    Pessoa toEntity(PessoaRequestDto dto);

    void updateEntityFromDTO(PessoaRequestDto dto, @MappingTarget Pessoa pessoa);
}
