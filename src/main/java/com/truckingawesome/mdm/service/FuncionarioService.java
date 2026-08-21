package com.truckingawesome.mdm.service;

import com.truckingawesome.mdm.dto.request.FuncionarioRequestDto;
import com.truckingawesome.mdm.mapper.request.FuncionarioRequestMapper;
import com.truckingawesome.mdm.mapper.response.FuncionarioResponseMapper;
import com.truckingawesome.mdm.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioResponseMapper funcionarioResponseMapper;
    private final FuncionarioRequestMapper funcionarioRequestMapper;

    @Transactional
    public void save(@Valid FuncionarioRequestDto dto) {
        dto.setId(null);
    }

}
