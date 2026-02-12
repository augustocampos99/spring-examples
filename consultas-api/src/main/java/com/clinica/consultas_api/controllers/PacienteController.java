package com.clinica.consultas_api.controllers;

import com.clinica.consultas_api.dtos.request.PacienteRequestDto;
import com.clinica.consultas_api.services.PacienteService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/V1/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(Pageable pageable) {
        var result = this.pacienteService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getById(@PathVariable UUID id) {
        var result = this.pacienteService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@Validated @RequestBody PacienteRequestDto request) {
        var result = this.pacienteService.create(request);
        return ResponseEntity.ok(result);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable UUID id, @Validated @RequestBody PacienteRequestDto request) {
        var result = this.pacienteService.update(id, request);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable UUID id) {
        this.pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
