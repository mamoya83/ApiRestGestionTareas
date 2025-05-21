package com.marcos.gestionTareas.services;

import com.marcos.gestionTareas.dto.req.ProyectoRequestDto;
import com.marcos.gestionTareas.dto.res.ResponseGlobalDto;
import com.marcos.gestionTareas.dto.res.ResponseProyectoDto;
import com.marcos.gestionTareas.models.Proyecto;
import com.marcos.gestionTareas.models.Tarea;
import com.marcos.gestionTareas.models.Usuario;
import com.marcos.gestionTareas.repositories.ProyectoRepository;
import com.marcos.gestionTareas.repositories.TareaRepository;
import com.marcos.gestionTareas.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProyectoService {

private final ProyectoRepository proyectoRepository;
private final UsuarioRepository usuarioRepository;
private final TareaRepository tareaRepository;

    public ProyectoService(ProyectoRepository proyectoRepository, UsuarioRepository usuarioRepository, TareaRepository tareaRepository) {
        this.proyectoRepository = proyectoRepository;
        this.usuarioRepository = usuarioRepository;
        this.tareaRepository = tareaRepository;
    }
    //Metodo para obtener todos los proyectos
    public ResponseGlobalDto getAllProyectos() {
        List<Proyecto> proyectos = proyectoRepository.findAll();
        if (proyectos.isEmpty()) {
            return new ResponseGlobalDto(
                    "no hay proyectos registrados",
                    404,
                    "api/proyectos",
                    LocalDateTime.now(),
                    null
            );
        }
            List<ResponseProyectoDto> proyectoDtos = proyectos.stream()
                    .map(p -> new ResponseProyectoDto(
                            p.getId(),
                            p.getName(),
                            p.getDescription(),
                            p.getTareas().stream()
                                    .map(t ->t.getUsuario() !=null ? t.getUsuario().getName() : "sin nombre")
                                    .collect(Collectors.joining(",")),
                            p.getUsuario() != null ? p.getUsuario().getName() : "sin nombre"
                    ))
                    .toList();

            return new ResponseGlobalDto(
                    "Lista de categorias obtenida correctamente",
                    200,
                    "api/proyectos",
                    LocalDateTime.now(),
                    proyectoDtos
            );
        }

    //Metodo para buscar proyecto por id
    public ResponseGlobalDto getProyectoById(Long id){
     Optional<Proyecto>proyectoObt = proyectoRepository.findById(id);
     if(proyectoObt.isPresent()){
         Proyecto proyecto = proyectoObt.get();
         return new ResponseGlobalDto(
                 "Proyecto encotrado",
                 200,
                 "api/proyectos",
                 LocalDateTime.now(),
                 proyecto
         );
     }else{
         return new ResponseGlobalDto(
                 "Proyecto no encontrado con id: ",
                 404,
                 "api/proyectos",
                 LocalDateTime.now(),
                 null
         );
     }
    }
    //Metodo para crear un proyecto
    public ResponseGlobalDto createProyecto(ProyectoRequestDto proyectoDto){
        // Buscar Usuario por ID
        Usuario usuario = usuarioRepository.findById(proyectoDto.getUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Buscar Tareas por ID (suponiendo que quieres asociar una lista de tareas)
        List<Tarea> tareas = tareaRepository.findAllById((proyectoDto.getTareas()));

        Proyecto proyecto = new Proyecto();
        proyecto.setName(proyectoDto.getName());
        proyecto.setDescription(proyectoDto.getDescription());
        proyecto.setTareas(tareas);
        proyecto.setUsuario(usuario);

        Proyecto proyectoNuv = proyectoRepository.save(proyecto);
        return new ResponseGlobalDto(
                "Proyecto creado con exito",
                200,
                "api/proyectos",
                LocalDateTime.now(),
                proyectoNuv
        );
    }
    //Metodo para actualizar un proyecto
    public ResponseGlobalDto updateProyecto(Long id,ProyectoRequestDto proyectoAct){
        Optional<Proyecto>proyectoObt =  proyectoRepository.findById(id);
        if(proyectoObt.isPresent()){
            Proyecto proyectoExt = proyectoObt.get();

            // Buscar Usuario por ID
            Usuario usuario = usuarioRepository.findById(proyectoAct.getUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            // Buscar Tareas por ID (en este caso se asume que el campo 'tareas' es una lista de IDs de tareas)
            List<Tarea> tareas = tareaRepository.findAllById((proyectoAct.getTareas()));

            proyectoExt.setName(proyectoAct.getName());
            proyectoExt.setDescription(proyectoAct.getDescription());
            proyectoExt.setTareas(tareas);
            proyectoExt.setUsuario(usuario);

            Proyecto proyectoActualizado = proyectoRepository.save(proyectoExt);
            return new ResponseGlobalDto(
                    "Proyecto actualizado",
                    200,
                    "api/proyectos",
                    LocalDateTime.now(),
                    proyectoActualizado
            );
        }else{
            return new ResponseGlobalDto(
                    "Producto no encontgrado con id :" + id,
                    404,
                    "api/proyectos",
                    LocalDateTime.now(),
                    null
            );
        }
    }
    //Metodo para eliminar un proyecto
    public ResponseGlobalDto deleteProyecto(Long id){
        Optional<Proyecto> proyecto = proyectoRepository.findById(id);
        if(proyecto.isPresent()){
             proyectoRepository.deleteById(id);
             return new ResponseGlobalDto(
                     "Proyecto eliminado",
                     200,
                     "api/proyectos",
                     LocalDateTime.now(),
                     null
             );
        }else{
            return new ResponseGlobalDto(
                    "Proyecto no encontrado con Id: " + id,
                    404,
                    "api/proyectos",
                    LocalDateTime.now(),
                    null
            );
        }
    }
}
