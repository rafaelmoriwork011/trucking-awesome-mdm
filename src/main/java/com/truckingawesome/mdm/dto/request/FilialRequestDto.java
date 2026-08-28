package com.truckingawesome.mdm.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilialRequestDto {
    private UUID id;

    @NotBlank(message = "Sigla é obrigatório")
    @Size(max = 30, message = "A sigla deve ter no máximo 3 caracteres")
    private String sigla;
}
