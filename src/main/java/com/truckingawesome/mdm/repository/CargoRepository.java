package com.truckingawesome.mdm.repository;

import com.truckingawesome.mdm.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, UUID> {
    Optional<Cargo> findOneByDescricao(String descricao);

    Optional<Cargo> findByDescricaoAndIdNot(String descricao, UUID id);
}
