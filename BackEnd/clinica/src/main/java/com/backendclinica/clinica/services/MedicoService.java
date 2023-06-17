package com.backendclinica.clinica.services;

import com.backendclinica.clinica.entities.Medico;
import com.backendclinica.clinica.entities.Paciente;

import java.util.List;

public interface MedicoService {
    void newMedico(Medico medico);

    List<Medico> getMedicos();

    Medico getMedico(Integer id);

    void updateMedico(Integer id, Medico medico);

    void deleteMedico(Integer id);
}
