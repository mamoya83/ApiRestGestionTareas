package com.marcos.gestionTareas.repositories;

import com.marcos.gestionTareas.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
