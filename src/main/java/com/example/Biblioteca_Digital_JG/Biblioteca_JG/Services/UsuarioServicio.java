package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Usuarios;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

  //Obtener todos los usuarios
  public List<Usuarios> getAllUsuarios() {
    return usuarioRepositorio.findAll();
  }

  //Eliminar usuario por ID
  public void deleteUsuarioById(int idUsuario) {
    usuarioRepositorio.deleteById(idUsuario);
  }

  //Actuqlizar Usuario
  public Usuarios updateUsuario(int idUsuario, Usuarios usuarioActualizado) {
    Optional<Usuarios> usuarioExistente = usuarioRepositorio.findById(idUsuario);

    if (usuarioExistente.isPresent()) {
      Usuarios usuario = usuarioExistente.get();
      usuario.setNombre(usuarioActualizado.getNombre());
      usuario.setEmail(usuarioActualizado.getEmail());
      // Agregar otras actualizaciones de campos según sea necesario
      return usuarioRepositorio.save(usuario);
    } else {
      return null; // O lanzar una excepción si el usuario no existe
    }
  }




}
