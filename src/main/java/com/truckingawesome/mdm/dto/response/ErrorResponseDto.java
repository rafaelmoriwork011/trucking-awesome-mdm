package com.truckingawesome.mdm.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {

    private List<String> messages;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FieldErrorResponseDto> fieldErrors;
}
