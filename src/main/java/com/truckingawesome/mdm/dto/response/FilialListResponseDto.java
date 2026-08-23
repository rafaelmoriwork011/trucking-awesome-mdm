package com.truckingawesome.mdm.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"id"})
public class FilialListResponseDto {
    private List<FilialResponseDto> filiais;
}
