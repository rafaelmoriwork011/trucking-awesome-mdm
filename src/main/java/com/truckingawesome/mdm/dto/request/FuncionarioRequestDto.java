package com.truckingawesome.mdm.dto.request;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuncionarioRequestDto {

    @Valid
    @JsonUnwrapped
    PessoaRequestDto pessoarRequestDto;

    private Integer id;

    @NotEmpty
    private Integer cargoId;

    @NotEmpty
    private Integer filialId;
}
