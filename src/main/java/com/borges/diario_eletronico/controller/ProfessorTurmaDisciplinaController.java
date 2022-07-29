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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.borges.diario_eletronico.domain.Professor;
import com.borges.diario_eletronico.domain.ProfessorTurmaDisciplina;
import com.borges.diario_eletronico.domain.dtos.ProfessorTurmaDisciplinaDTO;
import com.borges.diario_eletronico.repository.ProfessorTurmaDisciplinaRepository;
import com.borges.diario_eletronico.service.ProfessorTurmaDisciplinaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/professorTurmaDisciplina")
public class ProfessorTurmaDisciplinaController {
	
	@Autowired
	private ProfessorTurmaDisciplinaService service;
	
	@Autowired
	private ProfessorTurmaDisciplinaRepository repository;
	
		
	/**
	 * Buscar ProfessorTurmaDisciplina pelo ID
	 */
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfessorTurmaDisciplinaDTO> findById(@PathVariable Integer id) {
		ProfessorTurmaDisciplina obj = service.findById(id);
		return ResponseEntity.ok().body(new ProfessorTurmaDisciplinaDTO(obj));
	}
	
	
	/*
	 * Busca todos os ProfessorTurmaDisciplina da base de dados*/
	
	@GetMapping
	public ResponseEntity<List<ProfessorTurmaDisciplinaDTO>> findAllTurmas(){
		List<ProfessorTurmaDisciplina> list = service.findAll();
		List<ProfessorTurmaDisciplinaDTO> listDTO = list.stream().map(x -> new ProfessorTurmaDisciplinaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	/*
	 * Atualizar um ProfessorTurmaDisciplina
	*/
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProfessorTurmaDisciplinaDTO> update(@PathVariable Integer id, @Valid @RequestBody ProfessorTurmaDisciplinaDTO objDTO) {
		ProfessorTurmaDisciplina obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ProfessorTurmaDisciplinaDTO(obj));
	}
	
	/*
	 * Cria um ProfessorTurmaDisciplina
	 */
	@PostMapping
	public ResponseEntity<ProfessorTurmaDisciplinaDTO> create(@Valid @RequestBody ProfessorTurmaDisciplinaDTO obj) {
		ProfessorTurmaDisciplina newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	
	/*
	 *  Delete um ProfessorTurmaDisciplina
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/listar")
	public List<Integer> findPersonByName(@RequestParam("professor") Professor professor){
		
		return this.repository.findByProfessor(professor)
				.stream()
				.map(ProfessorTurmaDisciplina:: hashCode)
				.collect(Collectors.toList());
		
	}
	
}