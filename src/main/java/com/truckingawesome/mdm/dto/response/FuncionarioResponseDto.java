package com.truckingawesome.mdm.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id"})
public class FuncionarioResponseDto {

    @JsonIgnoreProperties("id")
    @JsonUnwrapped
    PessoaResponseDto pessoaResponseDto;
    private UUID id;

    private UUID cargoId;

    private UUID filialId;
}
