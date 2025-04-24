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
}
