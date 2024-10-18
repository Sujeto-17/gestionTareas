package com.example.gestiontareas.services;

import com.example.gestiontareas.entities.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaService {

    //Lista todas las tareas
    List<Tarea> getAllTareas();

    //Obtener tarea por id
    Optional<Tarea> getTareaById(Long id);

    //Crear tarea
    Tarea createTarea(Tarea tarea);

    //Actualizar tarea
    Tarea updateTarea(Long id, Tarea tarea);

    //Eliminar tarea
    void deleteTarea(Long id);
}
