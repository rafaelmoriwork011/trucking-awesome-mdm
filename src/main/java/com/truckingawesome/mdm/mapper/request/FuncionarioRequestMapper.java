package com.truckingawesome.mdm.mapper.request;

import com.truckingawesome.mdm.domain.Funcionario;
import com.truckingawesome.mdm.dto.request.FuncionarioRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FuncionarioRequestMapper {

    @Mapping(target = "pessoa", source = "pessoaRequestDto")
    @Mapping(target = "cargo.id", source = "cargoId")
    @Mapping(target = "filial.id", source = "filialId")
    @Mapping(target = "id", ignore = true)
    Funcionario toEntity(FuncionarioRequestDto dto);
}
