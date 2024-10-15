package com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO;

public class CategoriaRequest {
  private String nombreCategoria;
  private String descripcion;

  // Constructor vacío
  public CategoriaRequest() {}

  public CategoriaRequest(String nombreCategoria, String descripcion) {
    this.nombreCategoria = nombreCategoria;
    this.descripcion = descripcion;
  }

  public String getNombreCategoria() {
    return nombreCategoria;
  }

  public void setNombreCategoria(String nombreCategoria) {
    this.nombreCategoria = nombreCategoria;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}
