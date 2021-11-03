package com.doceria.renata.service;

import com.doceria.renata.exception.ErrorApiException;
import com.doceria.renata.model.Usuario;
import com.doceria.renata.model.request.UsuarioRequest;
import com.doceria.renata.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.net.URI;
import java.util.Optional;
import java.util.Date;
import java.util.HashMap;
import javax.crypto.SecretKey;
import java.util.List;
import java.util.ArrayList;

@Service
public class UsuarioService {

    public static int expiraEm = 600;

    // @Value("${jwt.secret}")
    // private String segredo;

    @Autowired
    public UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        List<Usuario> ls = new ArrayList<>();
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        usuarios.forEach(ls::add);
        return ls;
    }

    public Boolean estaLogado(UsuarioRequest usuarioRequest) {
        Optional<Usuario> usuarioOptional = Optional.empty();
        Iterable<Usuario> usuarios = usuarioRepository.findAll();

        for(Usuario u : usuarios)
        {
            if(u.getEmail().equals(usuarioRequest.getEmail())) {
                usuarioOptional = Optional.of(u);
                break;
            }
        }

        if(usuarioOptional.isEmpty())
        {
            return false;
        }

        return validarToken(usuarioOptional.get());
    }

    public ResponseEntity<Void> insert(Usuario usuario) {
        usuarioRepository.save(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    public ResponseEntity<Void> login(UsuarioRequest usuarioRequest) {
        Optional<Usuario> usuarioOptional = Optional.empty();
        Iterable<Usuario> usuarios = usuarioRepository.findAll();

        for(Usuario u : usuarios)
        {
            if(u.getEmail().equals(usuarioRequest.getEmail())) {
                usuarioOptional = Optional.of(u);
                break;
            }
        }

        if(usuarioOptional.isEmpty())
        {
            throw new ErrorApiException(HttpStatus.UNAUTHORIZED, "Usuário e/ou Senha incorretos.");
        }
        Usuario usuario_bd = usuarioOptional.get();
        if(!usuario_bd.getSenha().equals(usuarioRequest.getSenha()))
        {
            throw new ErrorApiException(HttpStatus.UNAUTHORIZED, "Usuário e/ou Senha incorretos.");
        }

        String token = Jwts.builder()
                    .setClaims(new HashMap<>())
                    .setSubject(usuario_bd.getId().toString())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + (expiraEm * 1000)))
                    .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS256))
                    .compact();

        usuario_bd.setToken(token);

        usuarioRepository.save(usuario_bd);
        
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> logout(UsuarioRequest usuarioRequest) {

        Optional<Usuario> usuarioOptional = Optional.empty();
        Iterable<Usuario> usuarios = usuarioRepository.findAll();

        for(Usuario u : usuarios)
        {
            if(u.getEmail().equals(usuarioRequest.getEmail())) {
                usuarioOptional = Optional.of(u);
                break;
            }
        }

        if(usuarioOptional.isEmpty())
        {
            throw new ErrorApiException(HttpStatus.UNAUTHORIZED, "Usuário inválido, impossível deslogar.");
        }
        Usuario usuario_bd = usuarioOptional.get();

        if(validarToken(usuario_bd))
        {
            usuario_bd.setToken("");
            usuarioRepository.save(usuario_bd);
        }

        return ResponseEntity.ok().build();
    }

    public static Boolean validarToken(Usuario usuario) {
        String token = usuario.getToken();

        if (token.equals(""))
            return false;

        SecretKey k = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        Claims c = Jwts.parserBuilder().setSigningKey(k).build().parseClaimsJws(token).getBody();

        return c.getSubject().equals(usuario.getId().toString()) && !c.getExpiration().before(new Date());
    }
}