package com.truckingawesome.mdm.dto.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioResponseDto {

    @JsonUnwrapped
    PessoaResponseDto pessoarResponseDto;

    private Integer id;

    private Integer cargoId;

    private Integer filialId;
}
