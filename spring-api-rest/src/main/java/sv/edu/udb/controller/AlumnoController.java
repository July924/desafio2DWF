package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.AlumnoRequest;
import sv.edu.udb.controller.response.AlumnoResponse;
import sv.edu.udb.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    // Crear alumno
    @PostMapping
    public AlumnoResponse agregarAlumno(@RequestBody AlumnoRequest request) {
        return alumnoService.agregarAlumno(request);
    }

    // Obtener alumno por ID
    @GetMapping("/{id}")
    public AlumnoResponse obtenerAlumno(@PathVariable int id) {
        return alumnoService.obtenerAlumnoPorId(id);
    }

    // Obtener todos los alumnos
    @GetMapping
    public List<AlumnoResponse> listarAlumnos() {
        return alumnoService.obtenerTodosLosAlumnos();
    }

    // Actualizar alumno
    @PutMapping("/{id}")
    public AlumnoResponse actualizarAlumno(@PathVariable int id, @RequestBody AlumnoRequest request) {
        return alumnoService.actualizarAlumno(id, request);
    }

    // Eliminar alumno
    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable int id) {
        alumnoService.eliminarAlumno(id);
    }
}
