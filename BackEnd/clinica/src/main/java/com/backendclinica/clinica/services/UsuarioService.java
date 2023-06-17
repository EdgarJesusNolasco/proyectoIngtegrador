package com.backendclinica.clinica.services;

import com.backendclinica.clinica.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    void newUsuario(Usuario usuario);

    List<Usuario> getUsuarios();

    void updateUsuario(Integer id, Usuario usuario);

    void deleteUsuario(Integer id);

    Usuario getUsuario(Integer id);
}
