package com.backendclinica.clinica.services.impl;

import com.backendclinica.clinica.entities.Usuario;
import com.backendclinica.clinica.repository.UsuarioReposity;
import com.backendclinica.clinica.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioReposity usuarioReposity;
    @Override
    public void newUsuario(Usuario usuario) {
        usuarioReposity.save(usuario);
    }

    @Override
    public List<Usuario> getUsuarios() {

        return usuarioReposity.findAll();
    }

    @Override
    public void updateUsuario(Integer id, Usuario usuario) {
        usuarioReposity.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));
        usuario.setId(id);

        usuarioReposity.save(usuario);
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuarioReposity.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));


        usuarioReposity.deleteById(id);
    }

    @Override
    public Usuario getUsuario(Integer id) {
        return usuarioReposity
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));

    }
}
