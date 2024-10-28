package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO.RegistroRequest;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Usuarios;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServicio {

  @Autowired
  private UsuarioRepositorio usuarioRepositorio;


  public void register(RegistroRequest registroRequest){
    Usuarios newUsuario = new Usuarios();
    newUsuario.setNombre(registroRequest.getNombre());
    newUsuario.setUsername(registroRequest.getUsername());
    newUsuario.setPass(registroRequest.getPassword());
    newUsuario.setEmail(registroRequest.getEmail());
    newUsuario.setAvatar(registroRequest.getAvatar());
    newUsuario.setRol(registroRequest.getRol());
    usuarioRepositorio.save(newUsuario);
  }



}
