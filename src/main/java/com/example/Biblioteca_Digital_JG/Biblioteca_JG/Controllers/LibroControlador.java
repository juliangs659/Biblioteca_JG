package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Controllers;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Libros;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.CallSite;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroControlador {

  @Autowired
  public LibroServicio libroServicio;

  //crear libro
  @PostMapping
  public ResponseEntity<Libros> createLibro(Libros libro){
    Libros libroNuevo = libroServicio.saveLibro(libro);
    return new ResponseEntity<>(libro, HttpStatus.CREATED);
  }

  //obtener todos los usuarios
  @GetMapping
  public ResponseEntity<List<Libros>> getAllLibros(){
    List<Libros> libros = libroServicio.getAllLibros();
    return new ResponseEntity<>(libros, HttpStatus.OK);
  }



}
