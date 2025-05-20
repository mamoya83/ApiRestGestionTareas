package com.marcos.gestionTareas.controllers;

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
    public ResponseEntity<List<Proyecto>> getAllProyectos(){
        List<Proyecto> proyectos = proyectoService.getAllProyectos();
        return ResponseEntity.ok(proyectos);
    }
    //Metodo para obtener proyecto por id
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto>getProyectoById(@PathVariable Long id){
        Optional<Proyecto>proyectoObt = proyectoService.getProyectoById(id);
        if(proyectoObt.isPresent()){
            return ResponseEntity.ok(proyectoObt.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    //Metodo para crear un proyecto
    @PostMapping
    public ResponseEntity<Proyecto> createProyecto(@RequestBody Proyecto proyecto){
        Proyecto proyectoNuv = proyectoService.createProyecto(proyecto);
        return ResponseEntity.ok(proyectoNuv);
    }
    //Metod para actualizar un proyecto
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> updateProyecto(@PathVariable Long id,@RequestBody Proyecto proyectoObt){
       Optional<Proyecto> proyectoAct = proyectoService.updateProyecto(id, proyectoObt);
       if(proyectoAct.isPresent()){
           return ResponseEntity.ok(proyectoAct.get());
       }else{
           return ResponseEntity.notFound().build();
       }
    }
    //Metodo para eliminar un proyecto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyecto(@PathVariable Long id){
        boolean eliminado = proyectoService.deleteProyecto(id);
        if (eliminado){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
