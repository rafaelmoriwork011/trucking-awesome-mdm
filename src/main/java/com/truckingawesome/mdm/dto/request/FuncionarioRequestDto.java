package com.truckingawesome.mdm.dto.request;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuncionarioRequestDto {

    @Valid
    @JsonUnwrapped
    PessoaRequestDto pessoaRequestDto;

    @NotNull(message = "O ID do cargo é obrigatório")
    private UUID cargoId;

    @NotNull(message = "O ID do cargo é obrigatório")
    private UUID filialId;
}
