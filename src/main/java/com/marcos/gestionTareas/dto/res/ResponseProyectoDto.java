package com.marcos.gestionTareas.dto.res;

public class ResponseProyectoDto {
    private Long id;
    private String name;
    private String description;
    private String nombreTarea;
    private String nombreUsuario;

    public ResponseProyectoDto() {
    }
    // Constructor

    public ResponseProyectoDto(Long id, String name, String description, String nombreTarea, String nombreUsuario) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.nombreTarea = nombreTarea;
        this.nombreUsuario = nombreUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
