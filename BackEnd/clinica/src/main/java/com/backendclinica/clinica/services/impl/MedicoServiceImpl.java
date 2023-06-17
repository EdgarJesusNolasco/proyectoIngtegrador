package com.backendclinica.clinica.services.impl;

import com.backendclinica.clinica.entities.Medico;
import com.backendclinica.clinica.entities.Paciente;
import com.backendclinica.clinica.repository.MedicoReposity;
import com.backendclinica.clinica.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private MedicoReposity medicoReposity;
    @Override
    public void newMedico(Medico medico) {
        medicoReposity.save(medico);
    }

    @Override
    public List<Medico> getMedicos() {
        return medicoReposity.findAll();
    }

    @Override
    public Medico getMedico(Integer id) {
        return medicoReposity
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));
    }

    @Override
    public void updateMedico(Integer id, Medico medico) {
        medicoReposity.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));
        medico.setId(id);

        medicoReposity.save(medico);
    }

    @Override
    public void deleteMedico(Integer id) {
        medicoReposity.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));


        medicoReposity.deleteById(id);
    }
}
