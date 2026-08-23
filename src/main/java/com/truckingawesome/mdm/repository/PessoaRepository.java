package com.truckingawesome.mdm.repository;

import com.truckingawesome.mdm.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Optional<Pessoa> findOneByCpfCnpj(String cpfCnpj);
}
