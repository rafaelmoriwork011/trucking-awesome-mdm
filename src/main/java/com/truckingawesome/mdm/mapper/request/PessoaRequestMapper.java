package com.truckingawesome.mdm.mapper.request;

import com.truckingawesome.mdm.domain.Pessoa;
import com.truckingawesome.mdm.dto.request.PessoaRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaRequestMapper {
    Pessoa toEntity(PessoaRequestDto dto);

}
