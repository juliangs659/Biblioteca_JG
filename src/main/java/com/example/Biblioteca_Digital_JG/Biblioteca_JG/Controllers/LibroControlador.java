package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Controllers;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO.LibroRequest;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Libros;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroControlador {

  @Autowired
  private LibroServicio libroServicio;

  // Crear libro con autor y categoría
  @PostMapping
  public ResponseEntity<Libros> crearLibro(@RequestBody LibroRequest libroRequest) {
    Libros libroGuardado = libroServicio.saveLibro(libroRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(libroGuardado);
  }

  // Obtener todos los libros
  @GetMapping
  public ResponseEntity<List<Libros>> getAllLibros() {
    List<Libros> libros = libroServicio.getAllLibros();
    return new ResponseEntity<>(libros, HttpStatus.OK);
  }
}
