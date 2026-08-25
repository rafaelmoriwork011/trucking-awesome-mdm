package com.truckingawesome.mdm.service;

import com.truckingawesome.mdm.dto.request.ClienteRequestDto;
import com.truckingawesome.mdm.dto.response.ClienteResponseDto;
import com.truckingawesome.mdm.dto.response.DataListResponseDto;
import com.truckingawesome.mdm.mapper.request.ClienteRequestMapper;
import com.truckingawesome.mdm.mapper.response.ClienteResponseMapper;
import com.truckingawesome.mdm.repository.ClienteRepository;
import com.truckingawesome.mdm.repository.FilialRepository;
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
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final PessoaRepository pessoaRepository;
    private final FilialRepository filialRepository;
    private final ClienteRequestMapper clienteRequestMapper;
    private final ClienteResponseMapper clienteResponseMapper;

    @Transactional
    public void save(@Valid ClienteRequestDto clienteRequestDto) {
        var pessoaRequestDto = clienteRequestDto.getPessoaRequestDto();

        this.pessoaRepository.findOneByCpfCnpj(pessoaRequestDto.getCpfCnpj()).ifPresent(pessoa -> {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe uma pessoa com CPF/CNPJ " + pessoaRequestDto.getCpfCnpj() + " cadastrada.");
        });

        this.filialRepository.findById(clienteRequestDto.getFilialId()).orElseThrow(() -> new EntityNotFoundException("Filial com identificador " + clienteRequestDto.getFilialId() + " não encontrado"));

        var cliente = this.clienteRequestMapper.toEntity(clienteRequestDto);

        this.clienteRepository.save(cliente);
    }

    @Transactional
    public void update(Integer id, @Valid ClienteRequestDto clienteRequestDto) {

        var cliente = this.clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente com identificador " + id + " não encontrado"));
        var filial = this.filialRepository.findById(clienteRequestDto.getFilialId()).orElseThrow(() -> new EntityNotFoundException("Filial com identificador " + clienteRequestDto.getFilialId() + " não encontrado"));
        var pessoaRequestDto = clienteRequestDto.getPessoaRequestDto();
        this.pessoaRepository.findOneByCpfCnpj(pessoaRequestDto.getCpfCnpj()).ifPresent(pessoa -> {
            if (!cliente.getPessoa().getId().equals(pessoa.getId())) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe uma pessoa com CPF/CNPJ " + pessoaRequestDto.getCpfCnpj() + " cadastrada.");
            }
        });

        cliente.setFilial(filial);
        this.clienteRequestMapper.updateEntityFromDto(clienteRequestDto, cliente);

        this.clienteRepository.save(cliente);
    }

    @Transactional
    public void deleteById(Integer id) {
        var cliente = this.clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente com identificador " + id + " não encontrado"));
        this.clienteRepository.delete(cliente);
    }

    public ClienteResponseDto findById(Integer id) {
        var cliente = this.clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente com identificador " + id + " não encontrado"));
        var clienteResponseDto = this.clienteResponseMapper.toDTO(cliente);

        return clienteResponseDto;
    }

    public DataListResponseDto<ClienteResponseDto> findAll() {
        var clientes = this.clienteRepository.findAll();
        var clienteResponseDtos = this.clienteResponseMapper.toDTOList(clientes);
        return DataListResponseDto.of(clienteResponseDtos);
    }
}
