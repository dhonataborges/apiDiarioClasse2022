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

import com.borges.diario_eletronico.domain.AlunoAula;
import com.borges.diario_eletronico.domain.dtos.AlunoAulaDTO;
import com.borges.diario_eletronico.service.AlunoAulaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/frequencia")
public class AlunoAulaController {
	
	@Autowired
	private AlunoAulaService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoAulaDTO> findById(@PathVariable Integer id) {
		AlunoAula obj = service.findById(id);
		return ResponseEntity.ok().body(new AlunoAulaDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<AlunoAulaDTO>> findAll() {
		List<AlunoAula> list = service.findAll();
		List<AlunoAulaDTO> listDTO = list.stream().map(x -> new AlunoAulaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<AlunoAulaDTO> create(@Valid @RequestBody AlunoAulaDTO objDTO) {
		AlunoAula obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlunoAulaDTO> update(@PathVariable Integer id, @Valid @RequestBody AlunoAulaDTO objDTO) {
		AlunoAula obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AlunoAulaDTO(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
		
}