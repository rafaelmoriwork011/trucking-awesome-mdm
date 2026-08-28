package com.truckingawesome.mdm.repository;

import com.truckingawesome.mdm.domain.Cargo;
import com.truckingawesome.mdm.domain.Filial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FilialRepository extends JpaRepository<Filial, UUID> {
    Optional<Filial> findOneBySigla(String sigla);
    Optional<Filial> findBySiglaAndIdNot(String sigla, UUID id);
}
