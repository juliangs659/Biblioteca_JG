package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Controllers;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO.LibroRequest;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO.LibrosRequest;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Libros;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.AutoresRespositorio;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services.AutorServicio;
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

  @Autowired
  private AutorServicio autorServicio;

  /*// Crear libro con autor y categoría
  @PostMapping
  public ResponseEntity<Libros> crearLibro(@RequestBody LibroRequest libroRequest) {
    Libros libroGuardado = libroServicio.saveLibro(libroRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(libroGuardado);
  }*/

  // Crear varios libros a la vez
  @PostMapping
  public ResponseEntity<Void> agregarLibros(@RequestBody List<LibroRequest> librosRequest) {
    for (LibroRequest libroRequest : librosRequest) {
      libroServicio.saveLibro(libroRequest);
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  // Obtener todos los libros
  @GetMapping
  public ResponseEntity<List<Libros>> getAllLibros() {
    List<Libros> libros = libroServicio.getAllLibros();
    return new ResponseEntity<>(libros, HttpStatus.OK);
  }

  //buscar libros por autor
  @GetMapping("/buscarPorAutor")
  public ResponseEntity<List<Libros>> buscarPorAutor(@RequestParam String nombreAutor) {
    List<Libros> libros = libroServicio.buscarPorAutor(nombreAutor);
    if (libros.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(libros);
  }
}
