package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Controllers;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Usuarios;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

  @Autowired
  public UsuarioServicio usuarioServicio;

  //crear usuario
  @PostMapping
  public ResponseEntity<Usuarios> createUsuario(@RequestBody Usuarios usuario){
    Usuarios usuarioNuevo = usuarioServicio.saveUsuario(usuario);
    return new ResponseEntity<>(usuarioNuevo, HttpStatus.CREATED);
  }

  //Obtener todos los Usuarios
  @GetMapping
  public ResponseEntity<List<Usuarios>> getAllUsuarios(){
    List<Usuarios> usuarios = usuarioServicio.getAllUsuarios();
    return new ResponseEntity<>(usuarios, HttpStatus.OK);
  }

}
