package com.backendclinica.clinica.controller;

import com.backendclinica.clinica.entities.Paciente;
import com.backendclinica.clinica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "http://localhost:4200")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/agregar")
    public String newPaciente(@RequestBody Paciente paciente){
        pacienteService.newPaciente(paciente);
        return "success add paciente";
    }
    @GetMapping("/mostrar")
    public List<Paciente> getPacientes(){
        return pacienteService.getPacientes();
    }

    @GetMapping("/get/{id}")
    public Paciente getPaciente(@PathVariable Integer id){
        return pacienteService.getPaciente(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updatePaciente(@PathVariable Integer id,@RequestBody Paciente paciente){
        pacienteService.updatePaciente(id, paciente);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePaciente(@RequestParam Integer id){
        pacienteService.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }
}
