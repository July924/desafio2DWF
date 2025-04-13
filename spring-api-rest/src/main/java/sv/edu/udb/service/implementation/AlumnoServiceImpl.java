package sv.edu.udb.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.AlumnoRequest;
import sv.edu.udb.controller.response.AlumnoResponse;
import sv.edu.udb.service.mapper.AlumnoMapper;
import sv.edu.udb.model.Alumno;
import sv.edu.udb.model.Materia;
import sv.edu.udb.repository.AlumnoRepository;
import sv.edu.udb.repository.MateriaRepository;
import sv.edu.udb.service.AlumnoService;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public AlumnoResponse agregarAlumno(AlumnoRequest request) {
        Optional<Materia> materiaOpt = materiaRepository.findById(request.getIdMateria());
        if (!materiaOpt.isPresent()) {
            throw new RuntimeException("Materia no encontrada");
        }

        Alumno alumno = new Alumno();
        alumno.setNombre(request.getNombre());
        alumno.setApellido(request.getApellido());
        alumno.setMateria(materiaOpt.get());

        Alumno guardado = alumnoRepository.save(alumno);
        return AlumnoMapper.toResponse(guardado);
    }

    @Override
    public AlumnoResponse obtenerAlumnoPorId(int id) {
        Optional<Alumno> alumnoOpt = alumnoRepository.findById(id);
        if (!alumnoOpt.isPresent()) {
            throw new RuntimeException("Alumno no encontrado");
        }
        return AlumnoMapper.toResponse(alumnoOpt.get());
    }

    @Override
    public List<AlumnoResponse> obtenerTodosLosAlumnos() {
        return List.of();
    }

    @Override
    public AlumnoResponse actualizarAlumno(int id, AlumnoRequest request) {
        return null;
    }

    @Override
    public void eliminarAlumno(int id) {

    }
}
