package com.truckingawesome.mdm.mapper.response;

import com.truckingawesome.mdm.domain.Pessoa;
import com.truckingawesome.mdm.dto.response.PessoaResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaResponseMapper {
    PessoaResponseDto toDTO(Pessoa pessoa);
}
