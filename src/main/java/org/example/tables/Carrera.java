package org.example.tables;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carrera;

    @Column
    private String carrera;

    @Column
    private int duracion;

    @OneToMany (mappedBy = "carrera")
    private List<Estudiante_carrera> carreras;

    public Carrera(String carrera, int duracion) {
        this.carrera = carrera;
        this.duracion = duracion;
        this.carreras = new ArrayList<>();
    }
}
