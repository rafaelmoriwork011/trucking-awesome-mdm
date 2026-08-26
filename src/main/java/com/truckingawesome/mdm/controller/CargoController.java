package com.truckingawesome.mdm.controller;

import com.truckingawesome.mdm.dto.request.CargoRequestDto;
import com.truckingawesome.mdm.dto.response.CargoResponseDto;
import com.truckingawesome.mdm.service.CargoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargos")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    @GetMapping
    public ResponseEntity<Page<CargoResponseDto>> findAll(@PageableDefault Pageable pageable) {
        Page<CargoResponseDto> cargos = cargoService.listAll(pageable);
        return ResponseEntity.ok(cargos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoResponseDto> findById(@PathVariable Integer id) {
        CargoResponseDto dto = cargoService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        cargoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CargoRequestDto dto) {
        cargoService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody CargoRequestDto dto) {
        cargoService.update(id, dto);
        return ResponseEntity.ok().build();
    }

}
