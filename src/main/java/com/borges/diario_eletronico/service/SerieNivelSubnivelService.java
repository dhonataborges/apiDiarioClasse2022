package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.SerieNivelSubnivel;
import com.borges.diario_eletronico.domain.dtos.SerieNivelSubnivelDTO;
import com.borges.diario_eletronico.repository.SerieNivelSubnivelRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class SerieNivelSubnivelService {
	
	
	@Autowired
	private SerieNivelSubnivelRepository repository;
		

	public SerieNivelSubnivel findById(Integer id) {
		Optional<SerieNivelSubnivel> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	public List<SerieNivelSubnivel> findAll(){
		return repository.findAll();
	}
	
public SerieNivelSubnivel create(SerieNivelSubnivelDTO objDTO) {
		
		return repository.save(new SerieNivelSubnivel(null, objDTO.getNivel(), objDTO.getSubnivel(), objDTO.getDescricao()));
		
	}

	public SerieNivelSubnivel update(Integer id, @Valid SerieNivelSubnivelDTO objDto) {
		
		SerieNivelSubnivel oldObj = findById(id);
		
		oldObj.setNivel(objDto.getNivel());
		oldObj.setSubnivel(objDto.getSubnivel());
		oldObj.setDescricao(objDto.getDescricao());
		return repository.save(oldObj);
		
	}

	public void delete(Integer id) {
		
		repository.deleteById(id);
	}
		
}
