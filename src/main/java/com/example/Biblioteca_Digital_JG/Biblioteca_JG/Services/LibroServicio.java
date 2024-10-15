package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO.LibroRequest;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Autores;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Categorias;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Libros;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.AutoresRespositorio;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.CategoriasRepositorio;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.LibrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicio {

  @Autowired
  private LibrosRepositorio librosRepository;

  @Autowired
  private AutoresRespositorio autoresRepository;

  @Autowired
  private CategoriasRepositorio categoriasRepository;

  // Metodo para guardar un nuevo libro
  public Libros saveLibro(LibroRequest libroRequest) {
    // Verificar si el autor ya existe
    Autores autor = autoresRepository.findByNombreAutor(libroRequest.getAutor().getNombreAutor());

    // Si no existe, guardarlo
    if (autor == null) {
      autor = libroRequest.getAutor();
      autoresRepository.save(autor);
    }

    // Verificar si la categoría ya existe
    Categorias categoria = categoriasRepository.findByNombreCategoria(libroRequest.getCategoria().getNombreCategoria());

    // Si no existe, guardarlo
    if (categoria == null) {
      categoria = libroRequest.getCategoria();
      categoriasRepository.save(categoria);
    }

    // Verificar si el libro ya existe
    Libros libroExistente = librosRepository.findByTitulo(libroRequest.getLibro().getTitulo());

    if (libroExistente != null) {
      throw new RuntimeException("El libro ya existe"); // Puedes lanzar una excepción personalizada si lo prefieres
    }

    // Crear el libro
    Libros libro = libroRequest.getLibro();
    libro.setAutor(autor); // Establecer la relación con el autor
    libro.setCategoria(categoria); // Establecer la relación con la categoría

    return librosRepository.save(libro);
  }

  // Metodo para obtener todos los libros
  public List<Libros> getAllLibros() {
    return librosRepository.findAll();
  }
}
