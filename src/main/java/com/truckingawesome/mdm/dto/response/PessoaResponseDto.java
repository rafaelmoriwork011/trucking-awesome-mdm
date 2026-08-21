package com.truckingawesome.mdm.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaResponseDto {

    private Integer id;

    private String nomeCompleto;

    private String cpfCnpj;
}
