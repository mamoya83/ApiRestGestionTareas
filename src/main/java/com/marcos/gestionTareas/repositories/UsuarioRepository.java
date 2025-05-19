package com.marcos.gestionTareas.repositories;

import com.marcos.gestionTareas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
