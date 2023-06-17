package com.backendclinica.clinica.controller;

import com.backendclinica.clinica.entities.Cita;
import com.backendclinica.clinica.entities.Especialidad;
import com.backendclinica.clinica.services.CitaService;
import com.backendclinica.clinica.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @PostMapping("/agregar")
    public String newCita(@RequestBody Cita cita){
        citaService.newCita(cita);
        return "success add medico";
    }
    @GetMapping("/mostrar")
    public List<Cita> getCitas(){
        return citaService.getCitas();
    }

    @GetMapping("/get/{id}")
    public Cita getCita(@PathVariable Integer id){
        return citaService.getCita(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCita(@PathVariable Integer id, @RequestBody Cita cita){
        citaService.updateCita(id, cita);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCita(@RequestParam Integer id){
        citaService.deleteCita(id);
        return ResponseEntity.noContent().build();
    }


}
