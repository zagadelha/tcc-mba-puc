package io.fourpet.controller;

import io.fourpet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.fourpet.entity.UsuarioEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioEntity> save(@RequestBody UsuarioEntity usuario) {

        usuario.setAnunciante(false);
        UsuarioEntity usuarioSalvo = repository.save(usuario);

        if (usuarioSalvo == null) {
            return ResponseEntity.notFound().build();
        } else {

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(usuarioSalvo.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(usuarioSalvo);
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioEntity> get(@PathVariable("id") String usuarioId) {

        UsuarioEntity usuario = repository.findById(usuarioId).get();
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<UsuarioEntity> update(@PathVariable("id") String usuarioId, @RequestBody UsuarioEntity usuario) {

        UsuarioEntity usuarioAtualizado = repository.save(usuario);
        if (usuarioAtualizado == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuarioAtualizado);
        }
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String usuarioId) {

        repository.deleteById(usuarioId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login-simples")
    public ResponseEntity<Boolean> entrarComCredenciais(@RequestBody UsuarioEntity usuario) {

        UsuarioEntity usuarioDB = repository.findByEmail(usuario.getEmail());
        if (usuarioDB != null && usuarioDB.getSenha().equals(usuario.getSenha())) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }

    @PostMapping("/login-google")
    public boolean entrarComGoogle(@RequestBody UsuarioEntity usuario) {
        //TODO: Implementar Google OAuth
        return true;
    }

}