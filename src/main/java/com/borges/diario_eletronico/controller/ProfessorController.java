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

import com.borges.diario_eletronico.domain.Professor;
import com.borges.diario_eletronico.domain.dtos.ProfessorDTO;
import com.borges.diario_eletronico.service.ProfessorService;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfessorDTO> findById(@PathVariable Integer id) {
		Professor obj = service.findById(id);
		return ResponseEntity.ok().body(new ProfessorDTO(obj));
	}
	
	
	@GetMapping
	public ResponseEntity<List<ProfessorDTO>> findAll() {
		List<Professor> list = service.findAll();
		List<ProfessorDTO> listDTO = list.stream().map(x -> new ProfessorDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProfessorDTO> update(@PathVariable Integer id, @RequestBody ProfessorDTO objDTO) {
		Professor obj =  service.update(id, objDTO);
		
		return ResponseEntity.ok().body(new ProfessorDTO(obj));
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<ProfessorDTO> create(@Valid @RequestBody ProfessorDTO obj) throws Exception {
		
		Professor newObj = service.create(obj);
							
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}