package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Controllers;

import com.example.Biblioteca_Digital_JG.Biblioteca_JG.DTO.RegistroRequest;
import com.example.Biblioteca_Digital_JG.Biblioteca_JG.Services.AuthServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthControlador {

  @Autowired
  private AuthServicio authServicio;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegistroRequest request) {
    authServicio.register(request);
    return ResponseEntity.ok("User registered successfully!");
  }
}
