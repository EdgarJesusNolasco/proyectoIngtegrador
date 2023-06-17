package com.backendclinica.clinica.repository;

import com.backendclinica.clinica.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteReposity extends JpaRepository<Paciente,Integer> {
}
