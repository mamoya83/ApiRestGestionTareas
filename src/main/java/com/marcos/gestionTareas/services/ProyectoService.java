package com.marcos.gestionTareas.services;

import com.marcos.gestionTareas.models.Proyecto;
import com.marcos.gestionTareas.repositories.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }
    //Metodo para obtener todos los proyectos
    public List<Proyecto> getAllProyectos(){
        return proyectoRepository.findAll();
    }
    //Metodo para buscar proyecto por id
    public Optional<Proyecto> getProyectoById(Long id){
     return proyectoRepository.findById(id);
    }
    //Metodo para crear un proyecto
    public Proyecto createProyecto(Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }
    //Metodo para actualizar una cita
    public Optional<Proyecto> updateProyecto(Long id,Proyecto proyectoAct){
        return proyectoRepository.findById(id).map(proyectoExt-> {
            proyectoExt.setName(proyectoAct.getName());
            proyectoExt.setDescription(proyectoAct.getDescription());
            proyectoExt.setTareas(proyectoAct.getTareas());
            proyectoExt.setUsuario(proyectoAct.getUsuario());
            return proyectoRepository.save(proyectoExt);
        });
    }
    //Metodo para eliminar un proyecto
    public boolean  deleteProyecto(Long id){
        Optional<Proyecto> proyecto = proyectoRepository.findById(id);
        if(proyecto.isPresent()){
             proyectoRepository.deleteById(id);
             return true;
        }else{
            return false;
        }
    }
}
