package com.example.gestiontareas.controller;

import com.example.gestiontareas.entities.Tarea;
import com.example.gestiontareas.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    //Listar todas las tareas
    public List<Tarea> listarTareas(){
        return tareaService.getAllTareas();
    }

    //Obtener tarea por id
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> listarTareaPorId(@PathVariable Long id){
        Optional<Tarea> tarea = tareaService.getTareaById(id);
        return tarea.map(value -> ResponseEntity.ok().body(value)).orElse(null);
    }

    //Guardar tareas
    @PostMapping
    public ResponseEntity<Tarea> guardarTarea(@RequestBody Tarea tarea){
        Tarea tareaGuardada = tareaService.createTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaGuardada);
    }

    //Actualizar tareas
    @PutMapping
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tarea){
        Tarea tareaUpdate = tareaService.updateTarea(id, tarea);
        if(tareaUpdate != null){
            return ResponseEntity.ok().body(tareaUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
