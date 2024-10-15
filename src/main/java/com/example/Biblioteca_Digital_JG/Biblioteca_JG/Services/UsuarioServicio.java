package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Usuarios;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicio {

  //Llamar al repositorio
  @Autowired
  private UsuarioRepositorio usuarioRepositorio;

  //Insertar Usuario
  private Usuarios saveUsuario(Usuarios usuario){
    return usuarioRepositorio.save(usuario);
  }

  //Obtener Usuario por ID
  private Optional<Usuarios> getUsuarioById(int idUsuario){
    return usuarioRepositorio.findById(idUsuario);
  }


}
