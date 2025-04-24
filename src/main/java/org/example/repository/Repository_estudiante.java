package org.example.repository;

import com.opencsv.CSVReader;
import jakarta.persistence.EntityManager;
import org.example.factory.JPAutil;
import org.example.tables.Carrera;
import org.example.tables.Estudiante;
import org.example.tables.Estudiante_carrera;

import java.io.FileReader;
import java.util.ArrayList;

public class Repository_estudiante {
    public void CargarCSV(String path){
        EntityManager ent = JPAutil.getEntityManager();
        String root = "src\\main\\resources\\" + path;

        try(CSVReader reader = new CSVReader(new FileReader(root))) {
            String[] tupla;
            reader.readNext();
            ArrayList<Estudiante_carrera> est_car = new ArrayList<>();

            ent.getTransaction().begin();

            while((tupla = reader.readNext()) != null) {
                int dni = Integer.parseInt(tupla[0]);
                String nombre = tupla[1];
                String apellido = tupla[2];
                int edad = Integer.parseInt(tupla[3]);
                String sexo = tupla[4];
                String ciudad = tupla[5];
                int LU = Integer.parseInt(tupla[6]);

                Estudiante estudiante = new Estudiante(dni, nombre, apellido, edad, sexo, ciudad, LU, est_car );
                ent.persist(estudiante);
            }
            ent.getTransaction().commit();

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            ent.close();
        }
    }
}
