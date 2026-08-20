package com.truckingawesome.mdm.helper;

import com.truckingawesome.mdm.dto.response.FieldErrorDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidationExceptionHelper {

    public List<FieldErrorDto> toFieldDTOList(List<FieldError> fieldErrors) {
        if (fieldErrors == null || fieldErrors.isEmpty()) {
            return List.of();
        }

        var mapping = Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList());
        var grouping = Collectors.groupingBy(FieldError::getField, mapping);

        var fieldError = FieldErrorDto.builder();

        return fieldErrors.stream().collect(grouping)
                .entrySet()
                .stream()
                .map(entry -> fieldError.field(entry.getKey()).message(entry.getValue()).build())
                .collect(Collectors.toList());
    }
}
