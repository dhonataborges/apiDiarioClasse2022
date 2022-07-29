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

import com.borges.diario_eletronico.domain.Disciplina;
import com.borges.diario_eletronico.domain.dtos.DisciplinaDTO;
import com.borges.diario_eletronico.service.DisciplinaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService service;
		
	/**
	 * Buscar Disciplina pelo ID
	 */
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DisciplinaDTO> findById(@PathVariable Integer id) {
		Disciplina obj = service.findById(id);
		return ResponseEntity.ok().body(new DisciplinaDTO(obj));
	}
	
	
	/*
	 * Busca todos os Disciplina da base de dados*/
	
	@GetMapping
	public ResponseEntity<List<DisciplinaDTO>> findAll() {
		List<Disciplina> list = service.findAll();
		List<DisciplinaDTO> listDTO = list.stream().map(x -> new DisciplinaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	/*
	 * Atualizar um Disciplina
	*/
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DisciplinaDTO> update(@PathVariable Integer id, @Valid @RequestBody DisciplinaDTO objDTO) {
		Disciplina obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new DisciplinaDTO(obj));
	}
	
	/*
	 * Cria um Disciplina
	 */
	@PostMapping
	public ResponseEntity<DisciplinaDTO> create(@Valid @RequestBody DisciplinaDTO obj) {
		Disciplina newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	
	/*
	 *  Delete um Disciplina
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}