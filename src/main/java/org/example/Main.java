package org.example;

import jakarta.persistence.EntityManager;
import org.example.factory.JPAutil;
import org.example.repository.Repository_carrera;
import org.example.repository.Repository_estudiante;
import org.example.repository.Repository_estudiante_carrera;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAutil.getEntityManager();
        Repository_carrera repo_car = new Repository_carrera();
        Repository_estudiante repo_est = new Repository_estudiante();
        Repository_estudiante_carrera repo_est_car = new Repository_estudiante_carrera();

        repo_car.CargarCSV("carreras.csv");
        repo_est.CargarCSV("estudiantes.csv");
        repo_est_car.CargarCSV("estudianteCarrera.csv");

      // c)  System.out.println("Estudiante ordenados alfabeticamente: " + repo_est.obtenerTodosEstudiantesOrdenados());
      // d)  System.out.println("Estudiante obtenido por numero legajo: " + repo_est.buscarEstudiantePorLU(28886));
      // e)  System.out.println("Estudiante obtenidos por genero: " + repo_est.buscarEstudiantesPorGenero("Polygender"));
      // f)  System.out.println("Carreras ordenadas por cantidad de inscriptos: " + repo_car.carrerasConMasInscriptos());
      // g)  System.out.println("Estudiantes obtenidos por carrera y ciudad: " + repo_est.estudiantesPorCarreraYciudad("Tudai", "Rauch"));
      // 3)  System.out.println("Reporte de carrera: " + repo_car.reporteCarrera(1, "TUDAI"));

        }
    }
