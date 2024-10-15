package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities;

import jakarta.persistence.*;

import javax.naming.Name;

@Entity
public class Favoritos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idFavorito;

  @ManyToOne
  @JoinColumn(name = "id_libro", nullable = false)
  private Libros libro;

  @ManyToOne
  @JoinColumn(name = "id_usuario", nullable = false)
  private Usuarios usuario;

  public Favoritos() {}

  public Favoritos(int idFavorito, Libros libro, Usuarios usuario) {
    this.idFavorito = idFavorito;
    this.libro = libro;
    this.usuario = usuario;
  }

  public int getIdFavorito() {
    return idFavorito;
  }

  public void setIdFavorito(int idFavorito) {
    this.idFavorito = idFavorito;
  }

  public Libros getLibro() {
    return libro;
  }

  public void setLibro(Libros libro) {
    this.libro = libro;
  }

  public Usuarios getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuarios usuario) {
    this.usuario = usuario;
  }

  @Override
  public String toString() {
    return "Favoritos{" +
            "idFavorito=" + idFavorito +
            ", libro=" + libro +
            ", usuario=" + usuario +
            '}';
  }
}
