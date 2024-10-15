package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
public class Libros {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idLibro;

  @Column(nullable = false)
  private String titulo;

  @Column(nullable = false)
  private String referenciaPdf;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EstadoLibro estado;

  @Column(nullable = false)
  private Timestamp fechaCreacion;

  @ManyToOne
  @JoinColumn(name = "idCategoria", nullable = false)
  private Categorias categoria;

  @ManyToOne
  @JoinColumn(name = "idAutor", nullable = false)
  private Autores autor;

  // Constructor vacío
  public Libros() {
    this.fechaCreacion = new Timestamp(System.currentTimeMillis());
    this.estado = EstadoLibro.UPLOADED; // Inicializar en el constructor
  }

  public Libros(String titulo, String referenciaPdf, EstadoLibro estado, Autores autor) {
    this.titulo = titulo;
    this.referenciaPdf = referenciaPdf;
    this.estado = estado;
    this.autor = autor;
  }

  // Getters y Setters

  public int getIdLibro() {
    return idLibro;
  }

  public void setIdLibro(int idLibro) {
    this.idLibro = idLibro;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getReferenciaPdf() {
    return referenciaPdf;
  }

  public void setReferenciaPdf(String referenciaPdf) {
    this.referenciaPdf = referenciaPdf;
  }

  public EstadoLibro getEstado() {
    return estado;
  }

  public void setEstado(EstadoLibro estado) {
    this.estado = estado;
  }

  public Timestamp getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(Timestamp fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
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

  // ...

  @Override
  public String toString() {
    return "Libros{" +
            "idLibro=" + idLibro +
            ", titulo='" + titulo + '\'' +
            ", referenciaPdf='" + referenciaPdf + '\'' +
            ", estado=" + estado +
            ", fechaCreacion=" + fechaCreacion +
            ", categoria=" + categoria +
            ", autor=" + autor +
            '}';
  }
}
