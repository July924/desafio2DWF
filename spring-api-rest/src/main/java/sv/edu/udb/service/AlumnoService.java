package sv.edu.udb.service;

import sv.edu.udb.controller.request.AlumnoRequest;
import sv.edu.udb.controller.response.AlumnoResponse;

import java.util.List;

public interface AlumnoService {
    AlumnoResponse agregarAlumno(AlumnoRequest request);
    AlumnoResponse obtenerAlumnoPorId(int id);
    List<AlumnoResponse> obtenerTodosLosAlumnos();
    AlumnoResponse actualizarAlumno(int id, AlumnoRequest request);
    void eliminarAlumno(int id);
}
