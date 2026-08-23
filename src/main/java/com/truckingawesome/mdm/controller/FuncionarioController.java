package com.truckingawesome.mdm.controller;

import com.truckingawesome.mdm.dto.request.FuncionarioRequestDto;
import com.truckingawesome.mdm.dto.response.DataListResponseDto;
import com.truckingawesome.mdm.dto.response.FuncionarioResponseDto;
import com.truckingawesome.mdm.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<DataListResponseDto<FuncionarioResponseDto>> findAll() {
        var dtos = funcionarioService.findAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> findById(@PathVariable Integer id) {
        var dto = funcionarioService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        funcionarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody FuncionarioRequestDto dto) {
        funcionarioService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody FuncionarioRequestDto dto) {
        funcionarioService.update(id, dto);
        return ResponseEntity.ok().build();
    }
}
