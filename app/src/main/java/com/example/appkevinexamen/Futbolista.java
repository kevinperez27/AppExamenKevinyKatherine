package com.example.appkevinexamen;

public class Futbolista {
    private int id;
    private String nombre;
    private String apellido;
    private String pais;
    private String posicion;
    private int edad;

    public Futbolista(int id, String nombre, String apellido, String pais, String posicion, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.posicion = posicion;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}

