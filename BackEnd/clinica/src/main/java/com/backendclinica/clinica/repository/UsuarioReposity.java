package com.backendclinica.clinica.repository;

import com.backendclinica.clinica.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioReposity extends JpaRepository<Usuario,Integer> {
}
