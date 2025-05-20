package com.marcos.gestionTareas.repositories;

import com.marcos.gestionTareas.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByProyectoId(Long proyectoId);
}
