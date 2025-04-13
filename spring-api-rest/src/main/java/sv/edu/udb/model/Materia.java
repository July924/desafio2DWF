package sv.edu.udb.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    private List<Alumno> alumnos;

    // Constructor vacío requerido por JPA
    public Materia() {
    }

    // Constructor con nombre
    public Materia(String nombre) {
        this.nombre = nombre;
    }

    // Constructor con id (opcional)
    public Materia(int id) {
        this.id = id;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
