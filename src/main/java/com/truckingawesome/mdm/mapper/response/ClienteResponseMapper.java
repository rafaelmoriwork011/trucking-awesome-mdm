package com.truckingawesome.mdm.mapper.response;

import com.truckingawesome.mdm.domain.Cliente;
import com.truckingawesome.mdm.dto.response.ClienteResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteResponseMapper {

    @Mapping(target = "pessoaResponseDto", source = "pessoa")
    @Mapping(target = "filialId", source = "filial.id")
    ClienteResponseDto toDTO(Cliente cliente);

    List<ClienteResponseDto> toDTOList(List<Cliente> clientes);
}
