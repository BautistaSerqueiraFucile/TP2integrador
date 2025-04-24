package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnioReporteDTO {

    private int anio;
    private long cantidadInscriptos;
    private long cantidadGraduados;

    @Override
    public String toString() {
        return "\n{" +
                "año=" + anio +
                ", cantidadInscriptos=" + cantidadInscriptos +
                ", cantidadGraduados=" + cantidadGraduados +
                '}';
    }
}
