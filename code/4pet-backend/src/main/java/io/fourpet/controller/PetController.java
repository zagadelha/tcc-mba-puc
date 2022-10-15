package io.fourpet.controller;

import io.fourpet.entity.PetEntity;
import io.fourpet.entity.UsuarioEntity;
import io.fourpet.repository.DatabaseFake;
//import io.fourpet.repository.UsuarioRepository;
import io.fourpet.util.RestResult;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@Slf4j
public class PetController {

    //@Autowired
    //private UsuarioRepository repository;

    /**
     * Endpoint responsável por cadastrar um novo Pet.
     * @param pet
     * @return O Pet cadastrado
     */
    @PostMapping("/pet")
    public RestResult<PetEntity> save(@RequestBody PetEntity pet) {

        //pet.setAnunciante(false);
//        UsuarioEntity usuarioSalvo = repository.save(usuario);
        PetEntity petSalvo = DatabaseFake.savePet(pet);

        if (petSalvo == null) {
            log.error("Erro no cadastro do pet: {}", pet.toString());
            return new RestResult<PetEntity>(true, null);
        } else {

            log.info("Pet cadastrado com sucesso: {}", pet.toString());
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(petSalvo.getId())
                    .toUri();

            return new RestResult<PetEntity>(true, petSalvo);
        }
    }

    /**
     * Endpoint responsável por listar os Pets de um usuário.
     * @param userId
     * @return Lista de Pets
     */
    @GetMapping("/pets/{userId}")
    public RestResult<List<PetEntity>> listPetsByUser(@PathVariable("userId") String userId) {

        log.info("Iniciando obter Pets por usuario: {}", userId);

//        UsuarioEntity usuario = repository.findById(usuarioId).get();

        List<PetEntity> filteredPets = DatabaseFake.findPetsByUser(userId);
        return new RestResult<List<PetEntity>>(true, filteredPets);


//        if (pets == null) {
//            log.info("Sucesso ao obter usuario: {}", usuario);
//            return new RestResult<UsuarioEntity>(true, usuario);
//        } else {
//            log.error("Falha ao obter usuario: {}", usuario);
//            return new RestResult<UsuarioEntity>(false, usuario);
//        }
    }

//    @GetMapping("/pet/{id}")
//    public RestResult<UsuarioEntity> get(@PathVariable("id") String usuarioId) {
//
//        log.info("Iniciando obter usuario: {}", usuarioId);
//
////        UsuarioEntity usuario = repository.findById(usuarioId).get();
//        UsuarioEntity usuario = DatabaseFake.findById(usuarioId);
//
//        if (usuario == null) {
//            log.info("Sucesso ao obter usuario: {}", usuario);
//            return new RestResult<UsuarioEntity>(true, usuario);
//        } else {
//            log.error("Falha ao obter usuario: {}", usuario);
//            return new RestResult<UsuarioEntity>(false, usuario);
//        }
//    }

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
//
//    @DeleteMapping("/usuario/{id}")
//    public ResponseEntity<Object> delete(@PathVariable("id") String usuarioId) {
//
//        repository.deleteById(usuarioId);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PostMapping("/login-simples")
//    public RestResult<UsuarioEntity> entrarComCredenciais(@RequestBody UsuarioEntity usuario) {
//
////        UsuarioEntity usuarioDB = repository.findByEmail(usuario.getEmail());
//        UsuarioEntity usuarioDB = DatabaseFake.findByEmail(usuario.getEmail());
//
//        if (usuarioValido(usuario, usuarioDB)) {
////            return ResponseEntity.ok(true);
//            return new RestResult<UsuarioEntity>(true, usuarioDB);
//        }
////        return ResponseEntity.ok(false);
//        return new RestResult<UsuarioEntity>(false, usuarioDB);
//    }
//
//    private static boolean usuarioValido(UsuarioEntity usuario, UsuarioEntity usuarioDB) {
//        return usuarioDB != null && usuarioDB.getSenha() != null && usuarioDB.getSenha().equals(usuario.getSenha());
//    }
//
//    @PostMapping("/login-google")
//    public boolean entrarComGoogle(@RequestBody UsuarioEntity usuario) {
//        //TODO: Implementar Google OAuth
//        return true;
//    }

}