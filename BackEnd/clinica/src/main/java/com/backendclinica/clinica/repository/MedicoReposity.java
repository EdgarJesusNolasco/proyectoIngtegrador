package com.backendclinica.clinica.repository;

import com.backendclinica.clinica.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoReposity extends JpaRepository<Medico,Integer> {
}
