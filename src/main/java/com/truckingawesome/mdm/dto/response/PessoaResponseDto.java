package com.truckingawesome.mdm.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
public class PessoaResponseDto {

    private UUID id;

    private String nomeCompleto;

    private String cpfCnpj;
}
