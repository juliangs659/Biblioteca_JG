package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Autores;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.AutoresRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio {

  @Autowired
  private AutoresRespositorio autoresRespositorio;


  // Guardar un nuevo autor
  public Autores saveAutor(Autores autor) {
    return autoresRespositorio.save(autor);
  }

  // Obtener todos los autores
  public List<Autores> getAllAutores() {
    return autoresRespositorio.findAll();
  }

  // Obtener un autor por su ID
  public Optional<Autores> getAutorById(int idAutor) {
    return autoresRespositorio.findById(idAutor);
  }

  // Buscar un autor por su nombre
  public Autores getAutorByNombre(String nombreAutor) {
    return autoresRespositorio.findByNombreAutor(nombreAutor);
  }

  // Actualizar un autor
  public Autores updateAutor(int idAutor, Autores autorActualizado) {
    Optional<Autores> autorExistente = autoresRespositorio.findById(idAutor);
    if (autorExistente.isPresent()) {
      Autores autor = autorExistente.get();
      autor.setNombreAutor(autorActualizado.getNombreAutor());
      return autoresRespositorio.save(autor);
    } else {
      throw new RuntimeException("El autor con ID " + idAutor + " no existe");
    }
  }

  // Eliminar un autor
  public void deleteAutor(int idAutor) {
    if (autoresRespositorio.existsById(idAutor)) {
      autoresRespositorio.deleteById(idAutor);
    } else {
      throw new RuntimeException("El autor con ID " + idAutor + " no existe");
    }
  }
}
