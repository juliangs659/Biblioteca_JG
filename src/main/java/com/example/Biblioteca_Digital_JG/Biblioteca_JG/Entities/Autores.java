package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Autores {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idAutor;

  @Column(unique = true)
  private String nombreAutor = "no registra";

  @JsonIgnore
  @OneToMany(mappedBy = "autor")
  private Set<Libros> libros;

  public Autores() {}

  public Autores(int idAutor, String nombreAutor, Set<Libros> libros) {
    this.idAutor = idAutor;
    this.nombreAutor = nombreAutor;
    this.libros = libros;
  }
  public Autores(String nombreAutor) {
    this.nombreAutor = nombreAutor;
    this.libros = new HashSet<>(); // Inicializa como un conjunto vacío
  }

  public Autores(String nombreAutor, Object o) {

  }


  public int getIdAutor() {
    return idAutor;
  }

  public void setIdAutor(int idAutor) {
    this.idAutor = idAutor;
  }

  public String getNombreAutor() {
    return nombreAutor;
  }

  public void setNombreAutor(String nombreAutor) {
    this.nombreAutor = nombreAutor;
  }

  public Set<Libros> getLibros() {
    return libros;
  }

  public void setLibros(Set<Libros> libros) {
    this.libros = libros;
  }

  @Override
  public String toString() {
    return "Autores{" +
            "idAutor=" + idAutor +
            ", nombreAutor='" + nombreAutor + '\'' +
            ", libros=" + libros +
            '}';
  }
}
