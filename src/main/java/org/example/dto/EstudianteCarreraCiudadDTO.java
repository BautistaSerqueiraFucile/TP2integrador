package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteCarreraCiudadDTO {

    private String nombre;
    private String apellido;
    private int dni;
    private String carrera;
    private String ciudad;

    @Override
    public String toString() {
        return "\n{" +
                "nombre=" + nombre +
                ", apellido=" + apellido +
                ", dni=" + dni +
                ", carrera=" + carrera +
                ", ciudad=" + ciudad +
                '}';
    }
}
