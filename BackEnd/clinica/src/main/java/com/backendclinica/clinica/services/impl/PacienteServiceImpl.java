package com.backendclinica.clinica.services.impl;

import com.backendclinica.clinica.entities.Paciente;
import com.backendclinica.clinica.repository.PacienteReposity;
import com.backendclinica.clinica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteReposity pacienteReposity;
    @Override
    public void newPaciente(Paciente paciente) {
        pacienteReposity.save(paciente);
    }

    @Override
    public List<Paciente> getPacientes() {
        return pacienteReposity.findAll();
    }

    @Override
    public Paciente getPaciente(Integer id) {
        return pacienteReposity
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));
    }

    @Override
    public void updatePaciente(Integer id, Paciente paciente) {
        pacienteReposity.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));
        paciente.setId(id);

        pacienteReposity.save(paciente);
    }

    @Override
    public void deletePaciente(Integer id) {
        pacienteReposity.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));


        pacienteReposity.deleteById(id);
    }


}
