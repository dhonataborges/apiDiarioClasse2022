/*package com.borges.diario_eletronico.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostFilter;
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

import com.borges.diario_eletronico.domain.ProfessorTurma;
import com.borges.diario_eletronico.domain.dtos.ProfessorTurmaDTO;
import com.borges.diario_eletronico.service.ProfessorTurmaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/professorTurmas")
public class ProfessorTurmaController {
	
	@Autowired
	private ProfessorTurmaService service;
		
	/**
	 * Buscar ProfessorTurma pelo ID
	 *
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfessorTurmaDTO> findById(@PathVariable Integer id) {
		ProfessorTurma obj = service.findById(id);
		return ResponseEntity.ok().body(new ProfessorTurmaDTO(obj));
	}
	
	
	/*
	 * Busca todos os ProfessorTurma da base de dados*
	
	@GetMapping
	public ResponseEntity<List<ProfessorTurmaDTO>> findAll() {
		List<ProfessorTurma> list = service.findAll();
		List<ProfessorTurmaDTO> listDTO = list.stream().map(x -> new ProfessorTurmaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	/*
	 * Atualizar um ProfessorTurma
	*
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProfessorTurmaDTO> update(@PathVariable Integer id, @Valid @RequestBody ProfessorTurmaDTO objDTO) {
		ProfessorTurma obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ProfessorTurmaDTO(obj));
	}
	
	/*
	 * Cria um ProfessorTurma
	 *
	@PostMapping
	public ResponseEntity<ProfessorTurmaDTO> create(@Valid @RequestBody ProfessorTurmaDTO obj) {
		ProfessorTurma newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	
	/*
	 *  Delete um ProfessorTurma
	 *
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}*/