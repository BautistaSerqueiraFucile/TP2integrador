package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarreraReporteDTO {

    private String nombreCarrera;
    private List<AnioReporteDTO> reportesPorAnio;

    @Override
    public String toString() {
        return "\n{" +
                "nombreCarrera='" + nombreCarrera + '\'' +
                ", reportesPorAño=" + reportesPorAnio +
                '}';
    }
}

