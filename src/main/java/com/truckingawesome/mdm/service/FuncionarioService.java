package com.truckingawesome.mdm.service;

import com.truckingawesome.mdm.dto.request.FuncionarioRequestDto;
import com.truckingawesome.mdm.dto.response.DataListResponseDto;
import com.truckingawesome.mdm.dto.response.FuncionarioResponseDto;
import com.truckingawesome.mdm.mapper.request.FuncionarioRequestMapper;
import com.truckingawesome.mdm.mapper.request.PessoaRequestMapper;
import com.truckingawesome.mdm.mapper.response.FuncionarioResponseMapper;
import com.truckingawesome.mdm.mapper.response.PessoaResponseMapper;
import com.truckingawesome.mdm.repository.CargoRepository;
import com.truckingawesome.mdm.repository.FilialRepository;
import com.truckingawesome.mdm.repository.FuncionarioRepository;
import com.truckingawesome.mdm.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final CargoRepository cargoRepository;
    private final PessoaRepository pessoaRepository;
    private final FilialRepository filialRepository;
    private final PessoaRequestMapper pessoaRequestMapper;
    private final FuncionarioRequestMapper funcionarioRequestMapper;
    private final FuncionarioResponseMapper funcionarioResponseMapper;
    private final PessoaResponseMapper pessoaResponseMapper;

    @Transactional
    public void save(@Valid FuncionarioRequestDto funcionarioRequestDto) {
        var pessoaRequestDto = funcionarioRequestDto.getPessoaRequestDto();

        this.pessoaRepository.findOneByCpfCnpj(pessoaRequestDto.getCpfCnpj()).ifPresent(pessoa -> {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe uma pessoa com CPF/CNPJ " + pessoaRequestDto.getCpfCnpj() + " cadastrada.");
        });

        this.cargoRepository.findById(funcionarioRequestDto.getCargoId()).orElseThrow(() -> new EntityNotFoundException("Cargo com identificador " + funcionarioRequestDto.getCargoId() + " não encontrado"));
        this.filialRepository.findById(funcionarioRequestDto.getFilialId()).orElseThrow(() -> new EntityNotFoundException("Filial com identificador " + funcionarioRequestDto.getFilialId() + " não encontrado"));

        var funcionario = this.funcionarioRequestMapper.toEntity(funcionarioRequestDto);

        this.funcionarioRepository.save(funcionario);
    }

    @Transactional
    public void update(Integer id, @Valid FuncionarioRequestDto funcionarioRequestDto) {

        var funcionario = this.funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionario com identificador " + id + " não encontrado"));
        this.cargoRepository.findById(funcionarioRequestDto.getCargoId()).orElseThrow(() -> new EntityNotFoundException("Cargo com identificador " + funcionarioRequestDto.getCargoId() + " não encontrado"));
        this.filialRepository.findById(funcionarioRequestDto.getFilialId()).orElseThrow(() -> new EntityNotFoundException("Filial com identificador " + funcionarioRequestDto.getFilialId() + " não encontrado"));
        var pessoaRequestDto = funcionarioRequestDto.getPessoaRequestDto();
        this.pessoaRepository.findOneByCpfCnpj(pessoaRequestDto.getCpfCnpj()).ifPresent(pessoa -> {
            if (!funcionario.getPessoa().getId().equals(pessoa.getId())) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe uma pessoa com CPF/CNPJ " + pessoaRequestDto.getCpfCnpj() + " cadastrada.");
            }
        });

        this.funcionarioRequestMapper.updateEntityFromDto(funcionarioRequestDto, funcionario);

        this.funcionarioRepository.save(funcionario);
    }

    @Transactional
    public void deleteById(Integer id) {
        var funcionario = this.funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionario com identificador " + id + " não encontrado"));
        this.funcionarioRepository.delete(funcionario);
    }

    public FuncionarioResponseDto findById(Integer id) {
        var funcionario = this.funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionario com identificador " + id + " não encontrado"));
        var funcionarioResponseDto = this.funcionarioResponseMapper.toDTO(funcionario);

        return funcionarioResponseDto;
    }

    public DataListResponseDto<FuncionarioResponseDto> findAll() {
        var funcionarios = this.funcionarioRepository.findAll();
        var funcionarioResponseDtos = this.funcionarioResponseMapper.toDTOList(funcionarios);
        return DataListResponseDto.of(funcionarioResponseDtos);
    }
}
