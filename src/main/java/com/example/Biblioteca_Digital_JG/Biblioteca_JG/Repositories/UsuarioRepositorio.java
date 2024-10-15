package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuarios, Integer> {
  // Para buscar por nombre de usuario
  Optional<Usuarios> findByUsername(String username);
}
