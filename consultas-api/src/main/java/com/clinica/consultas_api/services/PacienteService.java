package com.clinica.consultas_api.services;

import com.clinica.consultas_api.domain.entities.Paciente;
import com.clinica.consultas_api.domain.repositories.PacienteRepository;
import com.clinica.consultas_api.dtos.request.PacienteRequestDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> findAll(Pageable pageable) {
        return this.pacienteRepository.findAll(pageable).toList();
    }

    public Optional<Paciente> findById(UUID id) {
        return this.pacienteRepository.findById(id);
    }

    public Paciente create(PacienteRequestDto pacienteDto) {
        var paciente = new Paciente();
        paciente.setCPF(pacienteDto.cpf());
        paciente.setNome(pacienteDto.nome());
        this.pacienteRepository.save(paciente);

        return paciente;
    }

    public Paciente update(UUID id, PacienteRequestDto pacienteDto) {
        var pacienteResult = this.pacienteRepository.findById(id);

        if(pacienteResult.isEmpty()) {
            return null;
        }

        var paciente = pacienteResult.get();
        paciente.setCPF(pacienteDto.cpf());
        paciente.setNome(pacienteDto.nome());
        this.pacienteRepository.save(paciente);

        return paciente;
    }

    public void delete(UUID id) {
        pacienteRepository.deleteById(id);
    }

}
