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

import com.borges.diario_eletronico.domain.AlunoAtividade;
import com.borges.diario_eletronico.domain.dtos.AlunoAtividadeDTO;
import com.borges.diario_eletronico.service.AlunoAtividadeService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/alunoAtividades")
public class AlunoAtividadeController {
	
	@Autowired
	private AlunoAtividadeService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoAtividadeDTO> findById(@PathVariable Integer id) {
		AlunoAtividade obj = service.findById(id);
		return ResponseEntity.ok().body(new AlunoAtividadeDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<AlunoAtividadeDTO>> findAll() {
		List<AlunoAtividade> list = service.findAll();
		List<AlunoAtividadeDTO> listDTO = list.stream().map(x -> new AlunoAtividadeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<AlunoAtividadeDTO> create(@Valid @RequestBody AlunoAtividadeDTO objDTO) {
		AlunoAtividade obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlunoAtividadeDTO> update(@PathVariable Integer id, @Valid @RequestBody AlunoAtividadeDTO objDTO) {
		AlunoAtividade obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AlunoAtividadeDTO(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
		
}