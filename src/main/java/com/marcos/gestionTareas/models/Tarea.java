package com.marcos.gestionTareas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea",nullable = false)
    private Long id;
    @Column(name  = "titulo",nullable = false,length = 50)
    private String title;
    @Column(name = "estado",nullable = false,length = 50)
    private String estado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proyecto",nullable = false)
    @JsonIgnore
    private Proyecto proyecto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",nullable = false)
    @JsonIgnore
    private Usuario usuario;

    public Tarea() {
    }

    public Tarea(Long id, String title, String estado, Proyecto proyecto, Usuario usuario) {
        this.id = id;
        this.title = title;
        this.estado = estado;
        this.proyecto = proyecto;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
