package org.example.repository;

import com.opencsv.CSVReader;
import jakarta.persistence.EntityManager;
import org.example.dto.EstudianteDTO;
import org.example.dto.EstudiantePorCarreraDTO;
import org.example.factory.JPAutil;
import org.example.tables.Carrera;
import org.example.tables.Estudiante;
import org.example.tables.Estudiante_carrera;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Repository_estudiante {

    public void CargarCSV(String path) {
        EntityManager ent = JPAutil.getEntityManager();
        String root = "src\\main\\resources\\" + path;

        try (CSVReader reader = new CSVReader(new FileReader(root))) {
            String[] tupla;
            reader.readNext();
            ArrayList<Estudiante_carrera> est_car = new ArrayList<>();

            ent.getTransaction().begin();

            while ((tupla = reader.readNext()) != null) {
                int dni = Integer.parseInt(tupla[0]);
                String nombre = tupla[1];
                String apellido = tupla[2];
                int edad = Integer.parseInt(tupla[3]);
                String sexo = tupla[4];
                String ciudad = tupla[5];
                int LU = Integer.parseInt(tupla[6]);

                Estudiante estudiante = new Estudiante(dni, nombre, apellido, edad, sexo, ciudad, LU, est_car);
                ent.persist(estudiante);
            }
            ent.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ent.close();
        }
    }

    public List<EstudianteDTO> obtenerTodosEstudiantesOrdenados() {
        EntityManager em = JPAutil.getEntityManager();
        String jpql = "SELECT NEW org.example.dto.EstudianteDTO(e.dni_estudiante, e.nombre, e.apellido, e.edad, e.genero, e.ciudad, e.lu) " +
                "FROM Estudiante e ORDER BY e.apellido";
        List<EstudianteDTO> lista = em.createQuery(jpql, EstudianteDTO.class).getResultList();
        em.close();
        return lista;
    }

    public EstudianteDTO buscarEstudiantePorLU(int lu) {
        EntityManager em = JPAutil.getEntityManager();
        String jpql = "SELECT NEW org.example.dto.EstudianteDTO(e.dni_estudiante, e.nombre, e.apellido, e.edad, e.genero, e.ciudad, e.lu) " +
                "FROM Estudiante e WHERE e.lu = :lu";
        EstudianteDTO estudiante = em.createQuery(jpql, EstudianteDTO.class)
                .setParameter("lu", lu)
                .getSingleResult();
        em.close();
        return estudiante;
    }

    public List<EstudianteDTO> buscarEstudiantesPorGenero(String genero) {
        EntityManager em = JPAutil.getEntityManager();
        String jpql = "SELECT NEW org.example.dto.EstudianteDTO(e.dni_estudiante, e.nombre, e.apellido, e.edad, e.genero, e.ciudad, e.lu) " +
                "FROM Estudiante e WHERE e.genero = :genero";
        List<EstudianteDTO> lista = em.createQuery(jpql, EstudianteDTO.class)
                .setParameter("genero", genero)
                .getResultList();
        em.close();
        return lista;
    }

    public List<EstudiantePorCarreraDTO> estudiantesPorCarreraYciudad(String carrera, String ciudad) {
        EntityManager em = JPAutil.getEntityManager();
        String jpql = "SELECT NEW org.example.dto.EstudianteCarreraCiudadDTO(e.nombre, e.apellido, e.dni_estudiante, c.carrera, e.ciudad) " +
                "FROM Estudiante_carrera ec JOIN ec.estudiante e JOIN ec.carrera c " +
                "WHERE c.carrera = :carrera AND e.ciudad = :ciudad";
        List<EstudiantePorCarreraDTO> lista = em.createQuery(jpql, EstudiantePorCarreraDTO.class)
                .setParameter("carrera", carrera)
                .setParameter("ciudad", ciudad)
                .getResultList();
        em.close();
        return lista;
    }
}
