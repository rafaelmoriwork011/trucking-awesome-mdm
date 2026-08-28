package com.truckingawesome.mdm.repository;

import com.truckingawesome.mdm.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    Optional<Pessoa> findOneByCpfCnpj(String cpfCnpj);
}
