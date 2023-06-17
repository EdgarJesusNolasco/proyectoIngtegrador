package com.backendclinica.clinica.controller;

import com.backendclinica.clinica.entities.Especialidad;
import com.backendclinica.clinica.entities.Medico;
import com.backendclinica.clinica.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
@CrossOrigin(origins = "http://localhost:4200")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @PostMapping("/agregar")
    public String newEspecialidad(@RequestBody Especialidad especialidad){
        especialidadService.newEspecialidad(especialidad);
        return "success add medico";
    }
    @GetMapping("/mostrar")
    public List<Especialidad> getEspecialidades(){
        return especialidadService.getEspecialidades();
    }

    @GetMapping("/get/{id}")
    public Especialidad getEspecialidad(@PathVariable Integer id){
        return especialidadService.getEspecialidad(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateEspecialidad(@PathVariable Integer id, @RequestBody Especialidad especialidad){
        especialidadService.updateEspecialidad(id, especialidad);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteEspecialidad(@RequestParam Integer id){
        especialidadService.deleteEspecialidad(id);
        return ResponseEntity.noContent().build();
    }

}
