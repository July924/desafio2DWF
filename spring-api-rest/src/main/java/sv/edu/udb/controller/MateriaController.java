package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.model.Materia;
import sv.edu.udb.service.MateriaService;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<Materia> listarMaterias() {
        return materiaService.obtenerTodasLasMaterias();
    }

    @GetMapping("/{id}")
    public Materia obtenerMateriaPorId(@PathVariable int id) {
        return materiaService.obtenerMateriaPorId(id);
    }

    @PutMapping("/{id}")
    public Materia actualizarMateria(@PathVariable int id, @RequestBody Materia materia) {
        return materiaService.actualizarMateria(id, materia);
    }
}
