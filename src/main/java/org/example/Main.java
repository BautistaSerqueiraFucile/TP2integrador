package org.example;

import jakarta.persistence.EntityManager;
import org.example.factory.JPAutil;
import org.example.repository.Repository_carrera;
import org.example.repository.Repository_estudiante;
import org.example.repository.Repository_estudiante_carrera;
import org.example.tables.Estudiante;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAutil.getEntityManager();
        Repository_carrera repo_car = new Repository_carrera();
        Repository_estudiante repo_est = new Repository_estudiante();
        Repository_estudiante_carrera repo_est_car = new Repository_estudiante_carrera();

        repo_car.CargarCSV("carreras.csv");
        repo_est.CargarCSV("estudiantes.csv");
        repo_est_car.CargarCSV("estudianteCarrera.csv");

        /*
        System.out.println("Punto 2. A: Dar de alta un estudiante:");
        Estudiante estudiante = new Estudiante(01, "Juan", "Perez", 22, "Male", "Rauch", 01);
        repo_est.darDeAltaEstudiante(em, estudiante);
        System.out.println("--------------------------");

        System.out.println("Punto 2. B: Matricular un estudiante en una carrera:");
        repo_est_car.matricularEstudianteEnCarrera(em,01,1, 2025);
        System.out.println("--------------------------");
        */

        System.out.println("Punto 2. C: Todos los estudiantes ordenados alfabeticamente:");
        System.out.println(repo_est.obtenerTodosEstudiantesOrdenados());
        System.out.println("--------------------------");

        System.out.println("Punto 2. D: Un estudiante según número de libreta:");
        System.out.println(repo_est.buscarEstudiantePorLU(28886));
        System.out.println("--------------------------");

        System.out.println("Punto 2. E: Todos los estudiantes según su genero:");
        System.out.println(repo_est.buscarEstudiantesPorGenero("Polygender"));
        System.out.println("--------------------------");

        System.out.println("Punto 2. F: Todas las carreras con estudiantes inscriptos, ordenados por cant de inscriptos:");
        System.out.println(repo_car.carrerasConMasInscriptos());
        System.out.println("--------------------------");

        System.out.println("Punto 2. G: Todos los estudiantes de una carrera y ciudad:");
        System.out.println(repo_est.estudiantesPorCarreraYciudad("Tudai", "Rauch"));
        System.out.println("--------------------------");

        System.out.println("Punto 3: Reporte de carreras, con inscriptos y egresados por año:");
        System.out.println("Reporte de carrera: " + repo_car.reporteCarrera(1, "TUDAI"));


        }
    }
