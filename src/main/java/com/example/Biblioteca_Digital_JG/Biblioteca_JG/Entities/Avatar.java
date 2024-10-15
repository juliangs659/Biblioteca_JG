package com.example.Biblioteca_Digital_JG.Biblioteca_JG.Entities;

public enum Avatar {
  AVATAR1("avatar1.png"),
  AVATAR2("avatar2.png"),
  AVATAR3("avatar3.png"),
  AVATAR4("avatar4.png"),
  AVATAR5("avatar5.png"),
  AVATAR6("avatar6.png"),
  AVATAR7("avatar7.png"),
  AVATAR8("avatar8.png"),
  AVATAR9("avatar9.png"),
  AVATAR10("avatar10.png");


  private final String fileName;

  Avatar(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }

}
