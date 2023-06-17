package com.backendclinica.clinica.services.impl;

import com.backendclinica.clinica.entities.Especialidad;
import com.backendclinica.clinica.repository.EspecialidadReposity;
import com.backendclinica.clinica.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {
    @Autowired
    private EspecialidadReposity especialidadReposity;
    @Override
    public void newEspecialidad(Especialidad especialidad) {
        especialidadReposity.save(especialidad);
    }

    @Override
    public Especialidad getEspecialidad(Integer id) {
        return especialidadReposity
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));

    }

    @Override
    public void updateEspecialidad(Integer id, Especialidad especialidad) {
        especialidadReposity.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));
        especialidad.setId(id);

        especialidadReposity.save(especialidad);
    }

    @Override
    public void deleteEspecialidad(Integer id) {
        especialidadReposity.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));


        especialidadReposity.deleteById(id);
    }

    @Override
    public List<Especialidad> getEspecialidades() {
        return especialidadReposity.findAll();
    }
}
