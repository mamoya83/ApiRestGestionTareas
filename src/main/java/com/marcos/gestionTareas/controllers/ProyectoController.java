package com.marcos.gestionTareas.controllers;

import com.marcos.gestionTareas.dto.req.ProyectoRequestDto;
import com.marcos.gestionTareas.dto.res.ResponseGlobalDto;
import com.marcos.gestionTareas.models.Proyecto;
import com.marcos.gestionTareas.services.ProyectoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/proyectos")
public class ProyectoController {
    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    //Metodo para obtener todos los proyectos
    @GetMapping
    public ResponseEntity<ResponseGlobalDto> getAllProyectos(){
        ResponseGlobalDto rspuesta = proyectoService.getAllProyectos();
        return ResponseEntity.ok(rspuesta);
    }
    //Metodo para obtener proyecto por id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseGlobalDto>getProyectoById(@PathVariable Long id){
        ResponseGlobalDto respuesta = proyectoService.getProyectoById(id);
            return ResponseEntity.status(respuesta.getCodigo()).body(respuesta);
        }
    //Metodo para crear un proyecto
    @PostMapping
    public ResponseEntity<ResponseGlobalDto> createProyecto(@RequestBody ProyectoRequestDto proyectoDto){
        ResponseGlobalDto respuesta = proyectoService.createProyecto(proyectoDto);
        return ResponseEntity.status(respuesta.getCodigo()).body(respuesta);
    }
    //Metod para actualizar un proyecto
    @PutMapping("/{id}")
    public ResponseEntity<ResponseGlobalDto> updateProyecto(@PathVariable Long id,@RequestBody ProyectoRequestDto proyectoDto){
        Proyecto proyecto = new Proyecto();
       ResponseGlobalDto respuesta = proyectoService.updateProyecto(id, proyectoDto);
           return ResponseEntity.status(respuesta.getCodigo()).body(respuesta);
       }

    //Metodo para eliminar un proyecto
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseGlobalDto> deleteProyecto(@PathVariable Long id) {
        ResponseGlobalDto respuesta = proyectoService.deleteProyecto(id);
        return ResponseEntity.status(respuesta.getCodigo()).body(respuesta);
    }
}