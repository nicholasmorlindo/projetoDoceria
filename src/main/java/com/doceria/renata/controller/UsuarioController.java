package com.doceria.renata.controller;

import com.doceria.renata.model.Usuario;
import com.doceria.renata.service.UsuarioService;
import com.doceria.renata.model.request.UsuarioRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();        
    }

    @GetMapping(value = "/estaLogado")
    public Boolean estaLogado(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        return usuarioService.estaLogado(usuarioRequest);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Void> insert(@RequestBody @Valid Usuario usuarioRequest){
        return usuarioService.insert(usuarioRequest);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Void> login(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        return usuarioService.login(usuarioRequest);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<Void> logout(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        return usuarioService.logout(usuarioRequest);
    }
}
