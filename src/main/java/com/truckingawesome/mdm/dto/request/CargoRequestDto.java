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
public class CargoRequestDto {

    private UUID id;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 30, message = "Descrição deve ter no máximo 30 caracteres")
    private String descricao;
}
