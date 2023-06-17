package com.backendclinica.clinica.controller;

import com.backendclinica.clinica.entities.Medico;
import com.backendclinica.clinica.entities.Paciente;
import com.backendclinica.clinica.services.MedicoService;
import com.backendclinica.clinica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping("/agregar")
    public String newMedico(@RequestBody Medico medico){
        medicoService.newMedico(medico);
        return "success add medico";
    }
    @GetMapping("/mostrar")
    public List<Medico> getMedicos(){
        return medicoService.getMedicos();
    }

    @GetMapping("/get/{id}")
    public Medico getMedico(@PathVariable Integer id){
        return medicoService.getMedico(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateMedico(@PathVariable Integer id, @RequestBody Medico medico){
        medicoService.updateMedico(id, medico);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteMedico(@RequestParam Integer id){
        medicoService.deleteMedico(id);
        return ResponseEntity.noContent().build();
    }
}
