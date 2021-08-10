package com.example.demo.contacto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;
@Document
public class Contacto {
    @Id
    private String id;
    private String nombre;
    private LocalDate fechaNacimiento;
    @Indexed(unique = true)
    private String email;
    private Genero genero;

    public Contacto(String nombre, LocalDate fechaNacimiento, String email, Genero genero) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.genero = genero;
    }

    public int getEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public String getId() {
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
