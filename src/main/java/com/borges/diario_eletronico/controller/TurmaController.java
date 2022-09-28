package com.borges.diario_eletronico.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.dtos.TurmaDTO;
import com.borges.diario_eletronico.service.TurmaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/turmas")
public class TurmaController {
	
	@Autowired
	private TurmaService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TurmaDTO> findById(@PathVariable Integer id) {
		Turma obj = service.findById(id);
		return ResponseEntity.ok().body(new TurmaDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<TurmaDTO>> findAll() {
		List<Turma> list = service.findAll();
		List<TurmaDTO> listDTO = list.stream().map(x -> new TurmaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<TurmaDTO> create(@Valid @RequestBody TurmaDTO objDTO) {
		Turma obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<TurmaDTO> update(@PathVariable Integer id, @Valid @RequestBody TurmaDTO objDTO) {
		Turma obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new TurmaDTO(obj));
	}

	//@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
		
}