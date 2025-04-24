package org.example.repository;


import com.opencsv.CSVReader;
import jakarta.persistence.EntityManager;
import org.example.dto.AnioReporteDTO;
import org.example.dto.CarreraDTO;
import org.example.dto.CarreraReporteDTO;
import org.example.factory.JPAutil;
import org.example.tables.Carrera;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


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

    public List<CarreraDTO> carrerasConMasInscriptos() {
        EntityManager em = JPAutil.getEntityManager();
        String jpql = "SELECT NEW org.example.dto.EstudiantePorCarreraDTO(c.carrera, COUNT(ec.estudiante)) " +
                "FROM Estudiante_carrera ec JOIN ec.carrera c " +
                "GROUP BY c.id_carrera, c.carrera, c.duracion " +
                "ORDER BY COUNT(ec.estudiante) DESC";
        List<CarreraDTO> lista = em.createQuery(jpql, CarreraDTO.class).getResultList();
        em.close();
        return lista;
    }

    public CarreraReporteDTO reporteCarrera(int idCarrera, String nombreCarrera) {
        EntityManager em = JPAutil.getEntityManager();
        String jpql = "SELECT NEW org.example.dto.AnioReporteDTO(ec.anio_inscripcion, COUNT(ec.estudiante), " +
                "SUM(CASE WHEN ec.anio_graduacion IS NOT NULL THEN 1 ELSE 0 END)) " +
                "FROM Estudiante_carrera ec WHERE ec.carrera.id_carrera = :idCarrera " +
                "GROUP BY ec.anio_inscripcion ORDER BY ec.anio_inscripcion";

        List<AnioReporteDTO> anios = em.createQuery(jpql, AnioReporteDTO.class)
                .setParameter("idCarrera", idCarrera)
                .getResultList();
        em.close();
        return new CarreraReporteDTO(nombreCarrera, anios);
    }
}
