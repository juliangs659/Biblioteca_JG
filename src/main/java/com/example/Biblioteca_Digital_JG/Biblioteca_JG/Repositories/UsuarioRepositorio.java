package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Repositories;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuarios, Integer> {
}
