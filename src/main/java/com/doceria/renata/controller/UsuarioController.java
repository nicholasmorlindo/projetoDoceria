package com.doceria.renata.controller;

import com.doceria.renata.model.Usuario;
import com.doceria.renata.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Usuario usuarioRequest){

        usuarioRepository.save(usuarioRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(usuarioRequest.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
