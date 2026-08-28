package com.truckingawesome.mdm.controller;

import com.truckingawesome.mdm.dto.request.FuncionarioRequestDto;
import com.truckingawesome.mdm.dto.response.FuncionarioResponseDto;
import com.truckingawesome.mdm.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<Page<FuncionarioResponseDto>> findAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        var dtos = funcionarioService.findAll(pageable);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody FuncionarioRequestDto dto) {
        funcionarioService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @Valid @RequestBody FuncionarioRequestDto dto) {
        funcionarioService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> findById(@PathVariable UUID id) {
        var dto = funcionarioService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        funcionarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
