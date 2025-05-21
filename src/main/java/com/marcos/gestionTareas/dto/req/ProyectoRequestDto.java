package com.marcos.gestionTareas.dto.req;

import com.marcos.gestionTareas.models.Tarea;
import com.marcos.gestionTareas.models.Usuario;

import java.util.List;

public class ProyectoRequestDto {

    private int id;
    private String name;
    private String description;
    private List<Long> tareas;
    private Long usuario;

    public ProyectoRequestDto() {
    }

    public ProyectoRequestDto(int id, String name, String description, List<Long> tareas, Long usuario) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tareas = tareas;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getTareas() {
        return tareas;
    }

    public void setTareas(List<Long> tareas) {
        this.tareas = tareas;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }
}