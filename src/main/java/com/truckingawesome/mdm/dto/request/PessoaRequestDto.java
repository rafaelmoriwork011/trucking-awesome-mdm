package com.truckingawesome.mdm.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaRequestDto {

    @NotBlank(message = "Nome completo é obrigatório")
    @Size(max = 30, message = "Nome deve ter no máximo 50 caracteres")
    private String nomeCompleto;

    @NotBlank(message = "CPF/CNPJ é obrigatório")
    @Size(max = 30, message = "CPF/CNPJ deve ter no máximo 14 caracteres")
    private String cpfCnpj;
}
