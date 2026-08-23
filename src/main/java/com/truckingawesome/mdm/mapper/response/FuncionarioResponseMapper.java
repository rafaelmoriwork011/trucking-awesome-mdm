package com.truckingawesome.mdm.mapper.response;

import com.truckingawesome.mdm.domain.Funcionario;
import com.truckingawesome.mdm.dto.response.FuncionarioResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionarioResponseMapper {

    @Mapping(target = "pessoaResponseDto", source = "pessoa")
    @Mapping(target = "cargoId", source = "cargo.id")
    @Mapping(target = "filialId", source = "filial.id")
    FuncionarioResponseDto toDTO(Funcionario funcionario);

    List<FuncionarioResponseDto> toDTOList(List<Funcionario> funcionarios);
}
