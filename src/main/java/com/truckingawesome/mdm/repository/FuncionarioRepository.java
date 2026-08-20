package com.truckingawesome.mdm.repository;

import com.truckingawesome.mdm.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    boolean existsByCargoId(Integer cargoId);
}
