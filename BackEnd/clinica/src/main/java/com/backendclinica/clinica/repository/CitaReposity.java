package com.backendclinica.clinica.repository;

import com.backendclinica.clinica.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CitaReposity extends JpaRepository<Cita,Integer> {


}
