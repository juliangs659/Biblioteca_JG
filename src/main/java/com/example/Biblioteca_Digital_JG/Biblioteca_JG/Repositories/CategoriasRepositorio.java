package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriasRepositorio extends JpaRepository<Categorias, Integer> {
  // Metodo para buscar una categoría por su nombre
  Categorias findByNombreCategoria(String nombreCategoria);
}
