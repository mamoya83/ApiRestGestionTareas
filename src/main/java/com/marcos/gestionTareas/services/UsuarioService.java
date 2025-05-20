package com.marcos.gestionTareas.services;

import com.marcos.gestionTareas.models.Usuario;
import com.marcos.gestionTareas.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    //Metodo para para obtener todos los usuarios
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }
    //Metodo para obtener usuario por id
    public Optional<Usuario> getUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }
    //Metodo para crear un usuario
    public Usuario createUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    //Metodo para actualizar usuario
    public Optional<Usuario> updateUsuario(Long id,Usuario usuarioAct){
        return usuarioRepository.findById(id).map(usuarioExt -> {
            usuarioExt.setName(usuarioAct.getName());
            usuarioExt.setLastname(usuarioAct.getLastname());
            usuarioExt.setEmail(usuarioAct.getEmail());
            return  usuarioRepository.save(usuarioExt);
        });
    }
    //Metodo para eliminar usuario
    public boolean deletetUsuario(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            usuarioRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
