package com.truckingawesome.mdm.repository;

import com.truckingawesome.mdm.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
    boolean existsByCargoId(UUID cargoId);
}
