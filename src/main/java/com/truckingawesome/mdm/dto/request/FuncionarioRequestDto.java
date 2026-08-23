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
public class FuncionarioRequestDto {

    @Valid
    @JsonUnwrapped
    PessoaRequestDto pessoaRequestDto;

    private Integer id;

    @NotNull(message = "O ID do cargo é obrigatório")
    private Integer cargoId;

    @NotNull(message = "O ID do cargo é obrigatório")
    private Integer filialId;
}
