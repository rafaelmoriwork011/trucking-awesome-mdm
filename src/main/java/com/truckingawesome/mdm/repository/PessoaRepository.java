package com.truckingawesome.mdm.repository;

import com.truckingawesome.mdm.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
