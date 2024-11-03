package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO.LibroRequest;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO.LibrosRequest;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Autores;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Categorias;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Libros;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.AutoresRespositorio;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.CategoriasRepositorio;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories.LibrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    // Verificar si el libro ya existe
    Libros libroExistente = librosRepository.findByTitulo(libroRequest.getLibro().getTitulo());

    if (libroExistente != null) {
      throw new RuntimeException("El libro ya existe"); // Puedes lanzar una excepción personalizada si lo prefieres
    }
    // Verificar si la categoría ya existe
    Categorias categoria = categoriasRepository.findByNombreCategoria(libroRequest.getCategoria().getNombreCategoria());

    // Si no existe, guardarlo
    if (categoria == null) {
      categoria = libroRequest.getCategoria();
      categoriasRepository.save(categoria);
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

  public List<Libros> buscarPorAutor(String nombreAutor) {
    return librosRepository.findByAutor_NombreAutor(nombreAutor);
  }

  //metodo para elimnar libro por ID
  public void eliminarPorId(Integer id) {
    if (!librosRepository.existsById(id)) {
      throw new RuntimeException("El libro con ID " + id + " no existe.");
    }
    librosRepository.deleteById(id);
  }

  //obtener libro por id
  public Libros buscarPorId(Integer id) {
    return librosRepository.findById(id).get();
  }



}
