package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudiantePorCarreraDTO {
    private String carrera;
    private long cantidad;

    @Override
    public String toString() {
        return "\n{" +
                "carrera='" + carrera + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
