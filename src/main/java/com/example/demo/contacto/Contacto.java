package com.example.demo.contacto;

import java.time.LocalDate;
import java.time.Period;

public class Contacto {
    private Long id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String email;
    private Genero genero;

    public Contacto(String nombre, LocalDate fechaNacimiento, String email, Genero genero) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.genero = genero;
    }

    public Contacto(Long id, String nombre, LocalDate fechaNacimiento, String email, Genero genero) {
        this.id=id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.genero = genero;
    }

    public Contacto(Long id,String nombre, String email) {
        this.id=id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + getEdad() +
                ", email='" + email + '\'' +
                ", genero=" + genero +
                '}';
    }
}
