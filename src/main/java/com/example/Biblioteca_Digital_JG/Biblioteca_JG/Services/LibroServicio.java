package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.EstadoLibro;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Libros;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.LibrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicio {

  @Autowired
  public LibrosRepositorio librosRepositorio;

  //insertar libro
  public Libros saveLibro(Libros libro){
    return librosRepositorio.save(libro);
  }

  //obtener libro por ID
  public Optional<Libros> getLibroById(int id) {
    return librosRepositorio.findById(id);
  }

  //obtener todos los libros
  public List<Libros> getAllLibros() {
    return librosRepositorio.findAll();
  }

  //actualizar libro por ID
  public Libros updateLibro(int idLibro, Libros libroDetails) {
    Libros libro = librosRepositorio.findById(idLibro)
            .orElseThrow(() -> new RuntimeException("Libro no encontrado con id: " + idLibro));

    libro.setTitulo(libroDetails.getTitulo());
    libro.setReferenciaPdf(libroDetails.getReferenciaPdf());
    libro.setEstado(libroDetails.getEstado());
    libro.setCategorias(libroDetails.getCategorias());
    libro.setAutor(libroDetails.getAutor());

    return librosRepositorio.save(libro);
  }

  //Eliminar libro por ID
  public void deleteLibro(int id) {
    librosRepositorio.deleteById(id);
  }

  // Obtener libros por estado
  public List<Libros> getLibrosByEstado(EstadoLibro estado) {
    return librosRepositorio.findByEstado(estado);
  }

  // Buscar libros por título o descripción de categoría
  public List<Libros> buscarPorTituloODescripcionCategoria(String keyword) {
    return librosRepositorio.buscarPorTituloODescripcionCategoria(keyword);
  }

}
