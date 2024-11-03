package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Controllers;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO.LibroRequest;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Libros;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services.AutorServicio;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/libros")
public class LibroControlador {

  @Autowired
  private LibroServicio libroServicio;

  @Autowired
  private AutorServicio autorServicio;



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

  // Eliminar libro por ID
  @DeleteMapping
  public ResponseEntity<Void> eliminarLibro(@RequestParam Integer id) {
    try {
      libroServicio.eliminarPorId(id);
      return ResponseEntity.noContent().build();
    } catch (RuntimeException e) { // Asegúrate de manejar una excepción si el libro no se encuentra
      return ResponseEntity.notFound().build();
    }
  }

  // obtener libro por ID
  @GetMapping("/{id}")
  public ResponseEntity<Libros> getLibroById(@PathVariable Integer id) {
    try {
      Libros libro = libroServicio.buscarPorId(id);
      return ResponseEntity.ok(libro); // Devuelve el libro encontrado
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra el libro
    }
  }
}
