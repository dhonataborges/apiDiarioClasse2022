 package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Disciplina;
import com.borges.diario_eletronico.domain.SerieNivelSubnivel;
import com.borges.diario_eletronico.domain.dtos.DisciplinaDTO;
import com.borges.diario_eletronico.repository.DisciplinaRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class DisciplinaService{
	
	@Autowired
	private DisciplinaRepository repository;
	
	@Autowired
	private SerieNivelSubnivelService serieService;
	
	public Disciplina findById(Integer id) {
		Optional<Disciplina> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Disciplina> findAll() {
		return repository.findAll();
	}

	public Disciplina create(DisciplinaDTO objDTO) {
		return repository.save(newDisciplina(objDTO));
	}
	
	public Disciplina update(Integer id, @Valid DisciplinaDTO objDTO) {
		objDTO.setId(id);
		Disciplina oldObj = findById(id);
		oldObj = newDisciplina(objDTO);
		return repository.save(oldObj);
	}
	
	private Disciplina newDisciplina(DisciplinaDTO obj) {
		SerieNivelSubnivel serie = serieService.findById(obj.getSerieNivelSubnivel());
		
		Disciplina disciplina = new Disciplina();
		if(obj.getId() != null) {
			disciplina.setId(obj.getId());
		}
		
		disciplina.setNome(obj.getNome());
		disciplina.setEmenta(obj.getEmenta());
		disciplina.setSerieNivelSubnivel(serie);
		
		return disciplina;
	}
	
	public void delete(Integer id) {
		
		repository.deleteById(id);
	}
	
	
}
