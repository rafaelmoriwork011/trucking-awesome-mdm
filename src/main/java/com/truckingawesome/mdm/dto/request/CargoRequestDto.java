package com.truckingawesome.mdm.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CargoRequestDto {

    private Integer id;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 30, message = "Descrição deve ter no máximo 30 caracteres")
    private String descricao;
}
