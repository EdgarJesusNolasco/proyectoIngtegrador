package com.backendclinica.clinica.services;

import com.backendclinica.clinica.entities.Especialidad;

import java.util.List;

public interface EspecialidadService {
    void newEspecialidad(Especialidad especialidad);

    Especialidad getEspecialidad(Integer id);

    void updateEspecialidad(Integer id, Especialidad especialidad);

    void deleteEspecialidad(Integer id);

    List<Especialidad> getEspecialidades();
}
