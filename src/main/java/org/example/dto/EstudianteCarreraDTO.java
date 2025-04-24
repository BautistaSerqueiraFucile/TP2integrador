package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteCarreraDTO {

    private int dniEstudiante;
    private int idCarrera;
    private int anioInscripcion;
    private Integer anioGraduacion;
    private int antiguedad;

    @Override
    public String toString() {
        return "EstudianteCarreraDTO{" +
                "dniEstudiante=" + dniEstudiante +
                ", idCarrera=" + idCarrera +
                ", anioInscripcion=" + anioInscripcion +
                ", anioGraduacion=" + anioGraduacion +
                ", antiguedad=" + antiguedad +
                '}';
    }
}

