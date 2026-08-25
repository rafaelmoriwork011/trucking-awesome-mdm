package com.truckingawesome.mdm.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id"})
public class ClienteResponseDto {
    @JsonIgnoreProperties("id")
    @JsonUnwrapped
    PessoaResponseDto pessoaResponseDto;
    private Integer id;

    private Integer filialId;
}
