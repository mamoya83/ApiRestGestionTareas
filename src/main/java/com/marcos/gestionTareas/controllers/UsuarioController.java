package com.marcos.gestionTareas.controllers;

import com.marcos.gestionTareas.models.Usuario;
import com.marcos.gestionTareas.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    //Metodo para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario>usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    //Metodo para obtener usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario>getUsuarioById(@PathVariable Long id){
        Optional<Usuario> usuarioObt = usuarioService.getUsuarioById(id);
        if(usuarioObt.isPresent()){
            return ResponseEntity.ok(usuarioObt.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    //Metodo para crear un usuario
    @PostMapping
    public ResponseEntity<Usuario>createUsuaio(@RequestBody Usuario usuario){
        Usuario usuarioNuv = usuarioService.createUsuario(usuario);
        return ResponseEntity.ok(usuarioNuv);
    }
    //Metodo actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario>updateUsuario(@PathVariable Long id,@RequestBody Usuario usuarioOtn){
       Optional<Usuario> usuarioAct = usuarioService.updateUsuario(id,usuarioOtn);
       if(usuarioAct.isPresent()){
           return ResponseEntity.ok(usuarioAct.get());
       }else{
           return ResponseEntity.notFound().build();
       }
    }
    //Metodo para eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteUsuario(@PathVariable Long id){
        boolean eliminado = usuarioService.deletetUsuario(id);
        if(eliminado){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
