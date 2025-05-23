package org.example.tables;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Estudiante {
    @Id
    private int dni_estudiante;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    private String apellido;

    @Column (nullable = false)
    private int edad;

    @Column
    private String genero;

    @Column
    private String ciudad;

    @Column (nullable = false)
    private int lu;

    @OneToMany (mappedBy = "estudiante")
    private List<Estudiante_carrera> carreras;

    public Estudiante(int dni, String nombre, String apellido, int edad, String genero, String ciudad, int lu) {
        this.dni_estudiante = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.lu = lu;
    }
}
