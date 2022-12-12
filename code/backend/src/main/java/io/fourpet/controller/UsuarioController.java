package io.fourpet.controller;

import io.fourpet.repository.DatabaseFake;
//import io.fourpet.repository.UsuarioRepository;
import io.fourpet.util.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.fourpet.entity.UsuarioEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RestController
@Slf4j
public class UsuarioController {

    //@Autowired
    //private UsuarioRepository repository;

    @PostMapping("/usuario")
    public RestResult<UsuarioEntity> save(@RequestBody UsuarioEntity usuario) {

        usuario.setAnunciante(false);
//        UsuarioEntity usuarioSalvo = repository.save(usuario);
        UsuarioEntity usuarioSalvo = DatabaseFake.save(usuario);

        if (usuarioSalvo == null) {
            log.error("Erro no cadastro do usuário: {}", usuario.toString());
            return new RestResult<UsuarioEntity>(true, null);
        } else {

            log.info("Usuário cadastrado com sucesso: {}", usuario.toString());
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(usuarioSalvo.getId())
                    .toUri();

            return new RestResult<UsuarioEntity>(true, usuarioSalvo);
        }
    }

    @GetMapping("/usuario/{id}")
    public RestResult<UsuarioEntity> get(@PathVariable("id") String usuarioId) {

        log.info("Iniciando obter usuario: {}", usuarioId);

//        UsuarioEntity usuario = repository.findById(usuarioId).get();
        UsuarioEntity usuario = DatabaseFake.findById(usuarioId);

        if (usuario != null) {
            log.info("Sucesso ao obter usuario: {}", usuario);
            return new RestResult<UsuarioEntity>(true, usuario);
        } else {
            log.error("Falha ao obter usuario: {}", usuario);
            return new RestResult<UsuarioEntity>(false, usuario);
        }
    }

//    @PutMapping("/usuario/{id}")
//    public ResponseEntity<UsuarioEntity> update(@PathVariable("id") String usuarioId, @RequestBody UsuarioEntity usuario) {
//
//        UsuarioEntity usuarioAtualizado = repository.save(usuario);
//        if (usuarioAtualizado == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(usuarioAtualizado);
//        }
//    }

//    @DeleteMapping("/usuario/{id}")
//    public ResponseEntity<Object> delete(@PathVariable("id") String usuarioId) {
//
//        repository.deleteById(usuarioId);
//        return ResponseEntity.noContent().build();
//    }

    @PostMapping("/login-simples")
    public RestResult<UsuarioEntity> entrarComCredenciais(@RequestBody UsuarioEntity usuario) {

//        UsuarioEntity usuarioDB = repository.findByEmail(usuario.getEmail());
        UsuarioEntity usuarioDB = DatabaseFake.findByEmail(usuario.getEmail());

        if (usuarioValido(usuario, usuarioDB)) {
//            return ResponseEntity.ok(true);
            return new RestResult<UsuarioEntity>(true, usuarioDB);
        }
//        return ResponseEntity.ok(false);
        return new RestResult<UsuarioEntity>(false, usuarioDB);
    }

    private static boolean usuarioValido(UsuarioEntity usuario, UsuarioEntity usuarioDB) {
        return usuarioDB != null && usuarioDB.getSenha() != null && usuarioDB.getSenha().equals(usuario.getSenha());
    }

    @PostMapping("/login-google")
    public boolean entrarComGoogle(@RequestBody UsuarioEntity usuario) {
        //TODO: Implementar Google OAuth
        return true;
    }

}