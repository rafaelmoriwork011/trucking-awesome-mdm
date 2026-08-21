package com.truckingawesome.mdm.service;

import com.truckingawesome.mdm.dto.request.FilialRequestDto;
import com.truckingawesome.mdm.dto.response.DataListResponseDto;
import com.truckingawesome.mdm.dto.response.FilialResponseDto;
import com.truckingawesome.mdm.mapper.request.FilialRequestMapper;
import com.truckingawesome.mdm.mapper.response.FilialResponseMapper;
import com.truckingawesome.mdm.repository.FilialRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class FilialService {

    private final FilialRepository filialRepository;
    private final FilialResponseMapper filialResponseMapper;
    private final FilialRequestMapper filialRequestMapper;

    @Transactional
    public void save(@Valid FilialRequestDto dto) {
        dto.setId(null);
        this.filialRepository.findOneBySigla(dto.getSigla()).ifPresent(filial -> {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe uma filial " + dto.getSigla() + " cadastrada.");
        });
        var filial = filialRequestMapper.toEntity(dto);
        this.filialRepository.save(filial);
    }

    public void update(Integer id, @Valid FilialRequestDto dto) {
        var filial = this.filialRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Filial com identificador " + id + " não encontrado"));
        dto.setId(id);

        this.filialRepository.findBySiglaAndIdNot(dto.getSigla(), dto.getId()).ifPresent(filialSiglaUsed -> {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe uma filial " + dto.getSigla() + " cadastrada.");
        });

        if (dto.getSigla().equals(filial.getSigla())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "A filial já possui esta nomenclatura");
        }

        filialRequestMapper.updateEntityFromDTO(dto, filial);
        this.filialRepository.save(filial);
    }

    public DataListResponseDto<FilialResponseDto> listAll() {
        var filiais = this.filialRepository.findAll();
        var filiaisResponseDto = this.filialResponseMapper.toDTOList(filiais);
        return DataListResponseDto.of(filiaisResponseDto);
    }

    public FilialResponseDto findById(Integer id) {
        var filial = this.filialRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Filial com identificador " + id + " não encontrado"));
        return filialResponseMapper.toDTO(filial);
    }

    @Transactional
    public void deleteById(Integer id) {
        var filial = this.filialRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Filial com identificador " + id + " não encontrado"));
        this.filialRepository.delete(filial);
    }

}
