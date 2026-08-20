package com.truckingawesome.mdm.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilialListResponseDto {
    private List<FilialResponseDto> filiais;
}
