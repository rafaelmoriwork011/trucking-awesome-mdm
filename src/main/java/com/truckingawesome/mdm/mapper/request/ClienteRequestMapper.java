package com.truckingawesome.mdm.mapper.request;

import com.truckingawesome.mdm.domain.Cliente;
import com.truckingawesome.mdm.dto.request.ClienteRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = { PessoaRequestMapper.class })
public interface ClienteRequestMapper {

    @Mapping(target = "pessoa", source = "pessoaRequestDto")
    @Mapping(target = "filial.id", source = "filialId")
    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteRequestDto dto);

    @Mapping(target = "pessoa", source = "pessoaRequestDto")
    @Mapping(target = "filial.id", source = "filialId")
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ClienteRequestDto dto, @MappingTarget Cliente entity);
}
