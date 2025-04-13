package sv.edu.udb.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.model.Materia;
import sv.edu.udb.repository.MateriaRepository;
import sv.edu.udb.service.MateriaService;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public List<Materia> obtenerTodasLasMaterias() {
        return materiaRepository.findAll();
    }

    @Override
    public Materia obtenerMateriaPorId(int id) {
        Optional<Materia> materia = materiaRepository.findById(id);
        return materia.orElseThrow(() -> new RuntimeException("Materia no encontrada con ID: " + id));
    }

    @Override
    public Materia actualizarMateria(int id, Materia nuevaMateria) {
        Materia materiaExistente = obtenerMateriaPorId(id);
        materiaExistente.setNombre(nuevaMateria.getNombre());
        return materiaRepository.save(materiaExistente);
    }
}
