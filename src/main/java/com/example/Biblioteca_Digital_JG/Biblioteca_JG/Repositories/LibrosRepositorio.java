package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.EstadoLibro;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Libros;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LibrosRepositorio extends JpaRepository<Libros, Integer> {

  //para buscar por el estado
  List<Libros> findByEstado(EstadoLibro estado);

  //para buscar por ID
  Libros findByIdLibro(Integer idLibro);

  // Metodo para buscar un libro por su título
  Libros findByTitulo(String titulo);

  // metodo para buscar por titulo y descripcion de la categoria
  @Query("SELECT l FROM Libros l JOIN l.categoria c WHERE l.titulo LIKE %?1% OR c.descripcion LIKE %?1%")
  List<Libros> buscarPorTituloODescripcionCategoria(String keyword);

  List<Libros> findByAutor_NombreAutor(String nombreAutor);

}
