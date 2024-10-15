package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Set;

@Entity
public class Usuarios {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idUsuario;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String pass;  // Almacenar la contraseña en formato hash (BINARY)

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Avatar avatar;  // Lista de avatares predefinidos

  @Column(nullable = false)
  private java.sql.Timestamp fecha_creacion = new java.sql.Timestamp(System.currentTimeMillis());

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Rol rol;

  public Usuarios(){}

  public Usuarios(int id_Usuario, String nombre, String username, String email, String pass, Avatar avatar, Timestamp fecha_creacion) {
    this.idUsuario = id_Usuario;
    this.nombre = nombre;
    this.username = username;
    this.email = email;
    this.pass = pass;
    this.avatar = avatar;
    this.fecha_creacion = fecha_creacion;
  }

  public Usuarios(String nombre, String username, String email, String pass) {
    this.nombre = nombre;
    this.username = username;
    this.email = email;
    this.pass = pass;
  }

// Getters y Setters

  public int getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(int id_Usuario) {
    this.idUsuario = id_Usuario;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public Avatar getAvatar() {
    return avatar;
  }

  public void setAvatar(Avatar avatar) {
    this.avatar = avatar;
  }

  public java.sql.Timestamp getFecha_creacion() {
    return fecha_creacion;
  }

  public void setFecha_creacion(java.sql.Timestamp fecha_creacion) {
    this.fecha_creacion = fecha_creacion;
  }

  @Override
  public String toString() {
    return "Usuarios{" +
            "idUsuario=" + idUsuario +
            ", nombre='" + nombre + '\'' +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", pass='" + pass + '\'' +
            ", avatar=" + avatar +
            ", fecha_creacion=" + fecha_creacion +
            ", roles=" + rol +
            '}';
  }
}
