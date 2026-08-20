package com.truckingawesome.mdm.mapper;

import com.truckingawesome.mdm.dto.response.ErrorResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ErrorResponseMapper {

    @Mapping(target = "messages", expression = "java(java.util.List.of(entityNotFoundException.getMessage()))")
    ErrorResponseDto toDTO(EntityNotFoundException entityNotFoundException);


}
