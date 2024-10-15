package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Comentarios {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idComentario;

  @ManyToOne
  @JoinColumn(name = "id_libro", nullable = false)
  private Libros libro;

  @ManyToOne
  @JoinColumn(name = "id_usuario", nullable = false)
  private Usuarios usuario;

  @Column(nullable = false)
  private String comentario;

  @Column(nullable = false)
  private Timestamp fechaCreacion;

  // Constructor sin parámetros
  public Comentarios() {
    this.fechaCreacion = new Timestamp(System.currentTimeMillis());
  }

  // Constructor con parámetros, si lo deseas
  public Comentarios(Libros libro, Usuarios usuario, String comentario) {
    this.libro = libro;
    this.usuario = usuario;
    this.comentario = comentario;
    this.fechaCreacion = new Timestamp(System.currentTimeMillis());
  }

  public int getIdComentario() {
    return idComentario;
  }

  public void setIdComentario(int idComentario) {
    this.idComentario = idComentario;
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

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public Timestamp getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(Timestamp fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  @Override
  public String toString() {
    return "Comentarios{" +
            "idComentario=" + idComentario +
            ", libro=" + libro +
            ", usuario=" + usuario +
            ", comentario='" + comentario + '\'' +
            ", fechaCreacion=" + fechaCreacion +
            '}';
  }
}
