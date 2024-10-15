package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities;

import jakarta.persistence.*;

@Entity
public class Calificaciones {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idCalificacion;

  @ManyToOne
  @JoinColumn(name = "id_libro", nullable = false)
  private Libros libro;

  @ManyToOne
  @JoinColumn(name = "id_usuario", nullable = false)
  private Usuarios usuario;

  @Column(nullable = false)
  private float calificacion;

  public Calificaciones() {}

  public Calificaciones(int idCalificacion, Libros libro, Usuarios usuario, float calificacion) {
    this.idCalificacion = idCalificacion;
    this.libro = libro;
    this.usuario = usuario;
    this.calificacion = calificacion;
  }

  public int getIdCalificacion() {
    return idCalificacion;
  }

  public void setIdCalificacion(int idCalificacion) {
    this.idCalificacion = idCalificacion;
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

  public float getCalificacion() {
    return calificacion;
  }

  public void setCalificacion(float calificacion) {
    this.calificacion = calificacion;
  }

  @Override
  public String toString() {
    return "Calificaciones{" +
            "idCalificacion=" + idCalificacion +
            ", libro=" + libro +
            ", usuario=" + usuario +
            ", calificacion=" + calificacion +
            '}';
  }
}

