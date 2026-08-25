package com.truckingawesome.mdm.dto.request;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequestDto {

    @Valid
    @JsonUnwrapped
    PessoaRequestDto pessoaRequestDto;

    @NotNull(message = "O ID da filial é obrigatório")
    private Integer filialId;
}
