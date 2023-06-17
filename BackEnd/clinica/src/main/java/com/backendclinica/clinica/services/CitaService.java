package com.backendclinica.clinica.services;

import com.backendclinica.clinica.entities.Cita;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CitaService {
    void newCita(Cita cita);

    List<Cita> getCitas();

    Cita getCita(Integer id);

    void updateCita(Integer id, Cita cita);

    void deleteCita(Integer id);



}
