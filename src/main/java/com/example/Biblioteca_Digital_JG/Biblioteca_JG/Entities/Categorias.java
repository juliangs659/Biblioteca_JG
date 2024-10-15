package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Categorias {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idCategoria;

  @Column(unique = true, nullable = false)
  private String nombreCategoria;

  @Column(nullable = false)
  private String descripcion;

  @ManyToMany(mappedBy = "categorias")
  private Set<Libros> libros;

  public Categorias() {}

  public Categorias(String nombreCategoria, String descripcion) {
    this.nombreCategoria = nombreCategoria;
    this.descripcion = descripcion;
  }

  public Categorias(int idCategoria, String nombreCategoria, String descripcion, Set<Libros> libros) {
    this.idCategoria = idCategoria;
    this.nombreCategoria = nombreCategoria;
    this.descripcion = descripcion;
    this.libros = libros;
  }

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

  public Set<Libros> getLibros() {
    return libros;
  }

  public void setLibros(Set<Libros> libros) {
    this.libros = libros;
  }

  @Override
  public String toString() {
    return "Categorias{" +
            "idCategoria=" + idCategoria +
            ", nombreCategoria='" + nombreCategoria + '\'' +
            ", descripcion='" + descripcion + '\'' +
            ", libros=" + libros +
            '}';
  }
}
