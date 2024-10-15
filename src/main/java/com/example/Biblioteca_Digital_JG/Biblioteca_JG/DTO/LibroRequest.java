package com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Autores;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Categorias;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Libros;

import java.util.Set;

public class LibroRequest {
  private Libros libro;
  private Categorias categoria;
  private Autores autor;

  public LibroRequest() {}

  public LibroRequest(Libros libro, Categorias categoria, Autores autor) {
    this.libro = libro;
    this.categoria = categoria;
    this.autor = autor;
  }

  public Libros getLibro() {
    return libro;
  }

  public void setLibro(Libros libro) {
    this.libro = libro;
  }

  public Categorias getCategoria() {
    return categoria;
  }

  public void setCategoria(Categorias categoria) {
    this.categoria = categoria;
  }

  public Autores getAutor() {
    return autor;
  }

  public void setAutor(Autores autor) {
    this.autor = autor;
  }
}
