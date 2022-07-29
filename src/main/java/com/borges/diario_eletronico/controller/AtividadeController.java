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

import com.borges.diario_eletronico.domain.Atividade;
import com.borges.diario_eletronico.domain.dtos.AtividadeDTO;
import com.borges.diario_eletronico.service.AtividadeService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/atividades")
public class AtividadeController {
	
	@Autowired
	private AtividadeService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AtividadeDTO> findById(@PathVariable Integer id) {
		Atividade obj = service.findById(id);
		return ResponseEntity.ok().body(new AtividadeDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<AtividadeDTO>> findAll() {
		List<Atividade> list = service.findAll();
		List<AtividadeDTO> listDTO = list.stream().map(x -> new AtividadeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<AtividadeDTO> create(@Valid @RequestBody AtividadeDTO objDTO) {
		Atividade obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AtividadeDTO> update(@PathVariable Integer id, @Valid @RequestBody AtividadeDTO objDTO) {
		Atividade obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AtividadeDTO(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
		
}