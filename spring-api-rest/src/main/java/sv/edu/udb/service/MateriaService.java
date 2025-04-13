package sv.edu.udb.service;

import sv.edu.udb.model.Materia;
import java.util.List;

public interface MateriaService {
    List<Materia> obtenerTodasLasMaterias();
    Materia obtenerMateriaPorId(int id);
    Materia actualizarMateria(int id, Materia materia);
}
