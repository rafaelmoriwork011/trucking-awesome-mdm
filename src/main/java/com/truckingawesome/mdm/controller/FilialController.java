package com.truckingawesome.mdm.controller;

import com.truckingawesome.mdm.dto.request.FilialRequestDto;
import com.truckingawesome.mdm.dto.response.DataListResponseDto;
import com.truckingawesome.mdm.dto.response.FilialResponseDto;
import com.truckingawesome.mdm.service.FilialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filiais")
@RequiredArgsConstructor
public class FilialController {

    private final FilialService filialService;

    @GetMapping
    public ResponseEntity<DataListResponseDto<FilialResponseDto>> listAll() {
        var response = filialService.listAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilialResponseDto> findById(@PathVariable Integer id) {
        FilialResponseDto dto = filialService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        filialService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody FilialRequestDto dto) {
        filialService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody FilialRequestDto dto) {
        filialService.update(id, dto);
        return ResponseEntity.ok().build();
    }

}
