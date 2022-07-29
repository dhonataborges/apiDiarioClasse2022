package com.borges.diario_eletronico.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.borges.diario_eletronico.domain.Aula;
import com.borges.diario_eletronico.domain.dtos.AulaDTO;
import com.borges.diario_eletronico.service.AulaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/aulas")
public class AulaController {
	
	@Autowired
	private AulaService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AulaDTO> findById(@PathVariable Integer id) {
		Aula obj = service.findById(id);
		return ResponseEntity.ok().body(new AulaDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<AulaDTO>> findAll() {
		List<Aula> list = service.findAll();
		List<AulaDTO> listDTO = list.stream().map(x -> new AulaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<AulaDTO> create(@Valid @RequestBody AulaDTO objDTO) {
		Aula obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AulaDTO> update(@PathVariable Integer id, @Valid @RequestBody AulaDTO objDTO) {
		Aula obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AulaDTO(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
		
}