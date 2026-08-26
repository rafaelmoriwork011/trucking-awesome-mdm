package com.truckingawesome.mdm.service;

import com.truckingawesome.mdm.dto.request.CargoRequestDto;
import com.truckingawesome.mdm.dto.response.CargoResponseDto;
import com.truckingawesome.mdm.mapper.request.CargoRequestMapper;
import com.truckingawesome.mdm.mapper.response.CargoResponseMapper;
import com.truckingawesome.mdm.repository.CargoRepository;
import com.truckingawesome.mdm.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final CargoResponseMapper cargoResponseMapper;
    private final CargoRequestMapper cargoRequestMapper;


    public Page<CargoResponseDto> listAll(Pageable pageable) {
        var cargosPage = this.cargoRepository.findAll(pageable);
        return cargosPage.map(this.cargoResponseMapper::toDTO);
    }

    public CargoResponseDto findById(Integer id) {
        var cargo = this.cargoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo com identificador " + id + " não encontrado"));
        return cargoResponseMapper.toDTO(cargo);
    }

    @Transactional
    public void deleteById(Integer id) {
        var cargo = this.cargoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo com identificador " + id + " não encontrado"));

        var cargoInUseByFuncionario = funcionarioRepository.existsByCargoId(cargo.getId());

        if (cargoInUseByFuncionario) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não é possível remover este cargo, pois ele está sendo usado por um ou mais funcionários.");
        }

        cargoRepository.deleteById(id);
    }

    @Transactional
    public void save(@Valid CargoRequestDto dto) {
        this.cargoRepository.findOneByDescricao(dto.getDescricao()).ifPresent(cargo -> {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe um cargo " + dto.getDescricao() + " cadastrado.");
        });
        var cargo = cargoRequestMapper.toEntity(dto);
        cargoRepository.save(cargo);
    }

    @Transactional
    public void update(Integer id, @Valid CargoRequestDto dto) {
        dto.setId(id);
        var cargo = this.cargoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo com identificador " + id + " não encontrado"));

        if (dto.getDescricao().equals(cargo.getDescricao())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "O cargo já possui esta nomenclatura");
        }

        this.cargoRepository.findByDescricaoAndIdNot(dto.getDescricao(), dto.getId()).ifPresent(cargoDescricaoUsed -> {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe um cargo " + dto.getDescricao() + " cadastrado.");
        });

        cargoRequestMapper.updateEntityFromDTO(dto, cargo);
        this.cargoRepository.save(cargo);
    }
}
