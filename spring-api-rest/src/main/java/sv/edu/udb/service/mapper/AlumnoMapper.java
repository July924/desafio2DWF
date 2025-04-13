package sv.edu.udb.service.mapper;

import sv.edu.udb.controller.response.AlumnoResponse;
import sv.edu.udb.model.Alumno;

public class AlumnoMapper {

    public static AlumnoResponse toResponse(Alumno alumno) {
        AlumnoResponse response = new AlumnoResponse();
        response.setId(alumno.getId());
        response.setNombre(alumno.getNombre());
        response.setApellido(alumno.getApellido());
        response.setNombreMateria(alumno.getMateria().getNombre());
        return response;
    }
}
