package com.marcos.gestionTareas.services;

import com.marcos.gestionTareas.models.Tarea;
import com.marcos.gestionTareas.models.Usuario;
import com.marcos.gestionTareas.repositories.TareaRepository;
import com.marcos.gestionTareas.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;
    private final UsuarioRepository usuarioRepository;

    public TareaService(TareaRepository tareaRepository, UsuarioRepository usuarioRepository) {
        this.tareaRepository = tareaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    //Metodo para obtener todas las tareas
    public List<Tarea> getAllTareas(){
        return tareaRepository.findAll();
    }
    //Metodo para obtener tarea por id
    public Optional<Tarea> getTareaById(Long id){
        return tareaRepository.findById(id);
    }
    //Metodo para crear una tarea
    public Tarea createTarea(Tarea tarea){
        return tareaRepository.save(tarea);
    }
    //Metodo para actualizar una tarea
    public Optional<Tarea> updateTarea(Long id,Tarea tareaAct){
        return tareaRepository.findById(id).map(tareaExt->{
            tareaExt.setTitle(tareaAct.getTitle());
            tareaExt.setEstado(tareaAct.getEstado());
            tareaExt.setProyecto(tareaAct.getProyecto());
            tareaExt.setUsuario(tareaAct.getUsuario());
            return tareaRepository.save(tareaExt);
        });
    }
    // Asignar un usuario a una tarea
    public ResponseEntity<Tarea> asignarUsuarioTarea(Long tareaId,Long usuarioId){
        Optional<Tarea>tarea = tareaRepository.findById(tareaId);
        Optional<Usuario>usuario = usuarioRepository.findById(usuarioId);
        if(tarea.isPresent() && usuario.isPresent()){
            Tarea tareaActualizada = tarea.get();
            tareaActualizada.setUsuario(usuario.get());
            tareaRepository.save(tareaActualizada);
            return ResponseEntity.ok(tareaActualizada);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    // Calcular avance de un proyecto
    public Map<String,Object> obtenerAvanceProyecto(Long proyectoId) {
        List<Tarea> tareas = tareaRepository.findByProyectoId(proyectoId);
        int totalTareas = tareas.size();
        long tareasCompletadas = tareas.stream()
                .filter(t -> "COMPLETADA".equalsIgnoreCase(t.getEstado()))
                .count();
        double porcentajeAvance = totalTareas == 0 ? 0 : (double)
                tareasCompletadas / totalTareas * 100;
        Map<String, Object> avance = new HashMap<>();
        avance.put("totalTareas", totalTareas);
        avance.put("tareasCompletadas", tareasCompletadas);
        avance.put("porcentajeAvance", porcentajeAvance);
        return avance;
    }

        //Metodo para eliminar una tarea
        public boolean deleteTarea(Long id){
            Optional<Tarea>tarea = tareaRepository.findById(id);
            if(tarea.isPresent()){
            tareaRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
