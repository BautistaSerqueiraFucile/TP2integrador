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

    }
}