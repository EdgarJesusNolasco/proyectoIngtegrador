package com.backendclinica.clinica.services;

import com.backendclinica.clinica.entities.Paciente;

import java.util.List;

public interface PacienteService {
    void newPaciente(Paciente paciente);

    List<Paciente> getPacientes();

    Paciente getPaciente(Integer id);

    void updatePaciente(Integer id, Paciente paciente);

    void deletePaciente(Integer id);
}
