package org.example.repository;

import com.opencsv.CSVReader;
import jakarta.persistence.EntityManager;
import org.example.factory.JPAutil;
import org.example.tables.Carrera;
import org.example.tables.Estudiante;
import org.example.tables.Estudiante_carrera;

import java.io.FileReader;
import java.util.ArrayList;

public class Repository_estudiante_carrera {

    public void CargarCSV(String path) {
        EntityManager ent = JPAutil.getEntityManager();
        String root = "src\\main\\resources\\" + path;

        try (CSVReader reader = new CSVReader(new FileReader(root))) {
            String[] tupla;
            reader.readNext();

            ent.getTransaction().begin();

            while ((tupla = reader.readNext()) != null) {
                Estudiante estudiante = ent.find(Estudiante.class, tupla[1]);
                Carrera carrera = ent.find(Carrera.class, tupla[2]);
                int inscripcion = Integer.parseInt(tupla[3]);
                int graduacion = Integer.parseInt(tupla[4]);
                int antiguedad = Integer.parseInt(tupla[5]);

                Estudiante_carrera est_car = new Estudiante_carrera(estudiante, carrera, inscripcion, graduacion, antiguedad);
                ent.persist(est_car);
            }
            ent.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ent.close();
        }
    }
}
