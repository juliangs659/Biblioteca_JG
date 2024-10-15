package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoresRespositorio extends JpaRepository<Autores, Integer> {

  // Metodo para buscar un autor por su nombre
  Autores findByNombreAutor(String nombreAutor);
}
