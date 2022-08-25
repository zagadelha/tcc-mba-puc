package io.fourpet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.fourpet.entity.UsuarioEntity;
import io.fourpet.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@PostMapping("/usuario")
	public UsuarioEntity save(@RequestBody UsuarioEntity usuario) {
		return repository.save(usuario);
	}

	@GetMapping("/usuario/{id}")
	public UsuarioEntity get(@PathVariable("id") String usuarioId) {
		return repository.getUsuarioById(usuarioId);
	}

	@PutMapping("/usuario/{id}")
	public String update(@PathVariable("id") String usuarioId, @RequestBody UsuarioEntity usuario) {
		repository.update(usuarioId, usuario);
		return "Usuario atualizado com sucesso!";
	}

	@DeleteMapping("/usuario/{id}")
	public String delete(@PathVariable("id") String usuarioId) {
		repository.delete(usuarioId);
		return "Usuario excluido com sucesso!";
	}

}