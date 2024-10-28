package com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Avatar;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities.Rol;

public class RegistroRequest {
  private String nombre;
  private String username;
  private String password;
  private String email;
  private Avatar avatar;
  private Rol rol;


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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Avatar getAvatar() {
    return avatar;
  }

  public void setAvatar(Avatar avatar) {
    this.avatar = avatar;
  }

  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }
}
