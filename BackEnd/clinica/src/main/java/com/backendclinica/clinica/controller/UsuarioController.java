package com.backendclinica.clinica.controller;

import com.backendclinica.clinica.entities.Medico;
import com.backendclinica.clinica.entities.Usuario;
import com.backendclinica.clinica.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/agregar")
    public String newUsuario(@RequestBody Usuario usuario){
        usuarioService.newUsuario(usuario);
        return "success add medico";
    }
    @GetMapping("/mostrar")
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    @GetMapping("/get/{id}")
    public Usuario getUsuario(@PathVariable Integer id){
        return usuarioService.getUsuario(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        usuarioService.updateUsuario(id, usuario);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUsuario(@RequestParam Integer id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
