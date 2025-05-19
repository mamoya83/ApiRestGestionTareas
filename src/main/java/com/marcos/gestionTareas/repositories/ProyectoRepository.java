package com.marcos.gestionTareas.repositories;

import com.marcos.gestionTareas.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto,Long> {
}
