package com.example.gestiontareas.services.impl;

import com.example.gestiontareas.entities.Tarea;
import com.example.gestiontareas.repositories.TareaRepository;
import com.example.gestiontareas.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    //Listar todas las tareas
    @Override
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    //Buscar tarea por id
    @Override
    public Optional<Tarea> getTareaById(Long id) {
        return tareaRepository.findById(id);
    }

    //Crear tarea
    @Override
    public Tarea createTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    //Actualizar tarea
    @Override
    public Tarea updateTarea(Long id, Tarea tarea) {
        if (tareaRepository.existsById(id)){
            return tareaRepository.save(tarea);
        }
        return null;
    }

    //Eliminar tarea
    @Override
    public void deleteTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}
