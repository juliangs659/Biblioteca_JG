package com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO;

import java.util.List;

public class LibrosRequest {
  private List<LibroRequest> libros; // Lista de LibroRequest

  public LibrosRequest() {}

  public LibrosRequest(List<LibroRequest> libros) {
    this.libros = libros;
  }

  public List<LibroRequest> getLibros() {
    return libros;
  }

  public void setLibros(List<LibroRequest> libros) {
    this.libros = libros;
  }
}
