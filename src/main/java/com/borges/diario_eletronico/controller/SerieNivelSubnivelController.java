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

import com.borges.diario_eletronico.domain.SerieNivelSubnivel;
import com.borges.diario_eletronico.domain.dtos.SerieNivelSubnivelDTO;
import com.borges.diario_eletronico.service.SerieNivelSubnivelService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/series")
public class SerieNivelSubnivelController {
	
	@Autowired
	private SerieNivelSubnivelService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SerieNivelSubnivelDTO> findById(@PathVariable Integer id) {
		SerieNivelSubnivel obj = service.findById(id);
		return ResponseEntity.ok().body(new SerieNivelSubnivelDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<SerieNivelSubnivelDTO>> findAll() {
		List<SerieNivelSubnivel> list = service.findAll();
		List<SerieNivelSubnivelDTO> listDTO = list.stream().map(x -> new SerieNivelSubnivelDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SerieNivelSubnivelDTO> update(@PathVariable Integer id, @Valid @RequestBody SerieNivelSubnivelDTO objDTO) {
		SerieNivelSubnivel obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new SerieNivelSubnivelDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<SerieNivelSubnivelDTO> create(@Valid @RequestBody SerieNivelSubnivelDTO obj) {
		SerieNivelSubnivel newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}