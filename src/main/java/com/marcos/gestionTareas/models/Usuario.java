package com.marcos.gestionTareas.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario",nullable = false)
    private Long id;
    @Column(name = "nombre",nullable = false,length = 50)
    private String name;
    @Column(name = "apellido",nullable = false,length = 50)
    private String lastname;
    @Column(name = "email",nullable = false,length = 40)
    private String email;
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Proyecto>proyectos;

    public Usuario() {
    }

    public Usuario(Long id, String name, String lastname, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
