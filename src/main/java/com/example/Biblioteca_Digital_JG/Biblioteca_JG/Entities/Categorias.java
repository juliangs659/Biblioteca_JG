package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Categorias {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idCategoria;

  @Column(nullable = false)
  private String nombreCategoria;

  @Column(nullable = true)
  private String descripcion; // Si tienes una descripción opcional

  @OneToMany(mappedBy = "categoria")
  private Set<Libros> libros;

  // Constructor vacío
  public Categorias() {}

  // Constructor con parámetros
  public Categorias(String nombreCategoria, String descripcion) {
    this.nombreCategoria = nombreCategoria;
    this.descripcion = descripcion;
  }

  // Getters y setters
  public int getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(int idCategoria) {
    this.idCategoria = idCategoria;
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

  @Override
  public String toString() {
    return "Categorias{" +
            "idCategoria=" + idCategoria +
            ", nombreCategoria='" + nombreCategoria + '\'' +
            ", descripcion='" + descripcion + '\'' +
            '}';
  }
}

