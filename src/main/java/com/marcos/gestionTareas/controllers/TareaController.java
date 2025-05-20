package com.marcos.gestionTareas.controllers;

import com.marcos.gestionTareas.models.Tarea;
import com.marcos.gestionTareas.services.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }
    //Obtener todas las tareas
    @GetMapping
    public ResponseEntity<List<Tarea>> getAllTareas(){
        List<Tarea> tareas= tareaService.getAllTareas();
        return ResponseEntity.ok(tareas);
    }
    //Metodo para obtener tarea por id
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable Long id){
        Optional<Tarea> tareaObt = tareaService.getTareaById(id);
        if(tareaObt.isPresent()){
            return ResponseEntity.ok(tareaObt.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    //Metodo para crear una tarea
    @PostMapping
    public ResponseEntity<Tarea> createTarea(@RequestBody Tarea tarea){
        Tarea tareaNuv = tareaService.createTarea(tarea);
        return ResponseEntity.ok(tareaNuv);
    }
    //Metodo para actualizar una tarea
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable Long id,@RequestBody Tarea tareaObt){
        Optional<Tarea> tareaAct = tareaService.updateTarea(id,tareaObt);
        if (tareaAct.isPresent()){
            return ResponseEntity.ok(tareaAct.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    //Metodo para asignar un usuario a una tarea
    @PutMapping("/{tareaId}/asignar/{usuarioId}")
    public ResponseEntity<Tarea> asignarUsuarioTarea(@PathVariable Long tareaId,@PathVariable Long usuarioId){
       return tareaService.asignarUsuarioTarea(tareaId,usuarioId);
    }
    //Metodo calcular avance de un proyecto
    @GetMapping("/proyecto/{proyectoId}/avance")
    public ResponseEntity<Map<String,Object>> obtenerAvanceProyecto(@PathVariable Long proyectoId){
        Map<String,Object> avance = tareaService.obtenerAvanceProyecto(proyectoId);
        return ResponseEntity.ok(avance);
    }
    //Metodo para eliminar una tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id){
        boolean eliminado = tareaService.deleteTarea(id);
        if(eliminado){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
