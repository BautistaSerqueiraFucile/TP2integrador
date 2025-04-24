package org.example.repository;


import com.opencsv.CSVReader;
import jakarta.persistence.EntityManager;
import org.example.factory.JPAutil;
import org.example.tables.Carrera;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;


public class Repository_carrera {
    public void CargarCSV(String path){
        EntityManager ent = JPAutil.getEntityManager();
        String root = "src\\main\\resources\\" + path;

        try(CSVReader reader = new CSVReader(new FileReader(root))) {
            String[] tupla;
            reader.readNext();

            ent.getTransaction().begin();

            while((tupla = reader.readNext()) != null) {
                String carr = tupla[1];
                int duracion = Integer.parseInt(tupla[2]);
                Carrera carrera = new Carrera(carr, duracion);
                ent.persist(carrera);
            }
            ent.getTransaction().commit();

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            ent.close();
        }
    }
}
