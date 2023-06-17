package com.backendclinica.clinica.services.impl;

import com.backendclinica.clinica.entities.Cita;
import com.backendclinica.clinica.repository.CitaReposity;
import com.backendclinica.clinica.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaReposity citaReposity;
    @Override
    public void newCita(Cita cita) {
        citaReposity.save(cita);
    }

    @Override
    public List<Cita> getCitas() {
        return citaReposity.findAll();
    }

    @Override
    public Cita getCita(Integer id) {
        return citaReposity
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));

    }

    @Override
    public void updateCita(Integer id, Cita cita) {
        citaReposity.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));
        cita.setId(id);

        citaReposity.save(cita);
    }

    @Override
    public void deleteCita(Integer id) {
        citaReposity.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));


        citaReposity.deleteById(id);
    }


}
