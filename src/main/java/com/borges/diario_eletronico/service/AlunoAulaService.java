package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.AlunoAula;
import com.borges.diario_eletronico.domain.Aula;
import com.borges.diario_eletronico.domain.dtos.AlunoAulaDTO;
import com.borges.diario_eletronico.repository.AlunoAulaRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class AlunoAulaService {

	@Autowired
	private AlunoAulaRepository repository;
	
	@Autowired	
	private AulaService aulaService;
	
	@Autowired	
	private AlunoService alunoService;

	public AlunoAula findById(Integer id) {
		Optional<AlunoAula> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<AlunoAula> findAll() {
		return repository.findAll();
	}

	public AlunoAula create(AlunoAulaDTO objDTO) {
		return repository.save(newAlunoAula(objDTO));
	}

	public AlunoAula update(Integer id, @Valid AlunoAulaDTO objDTO) {
		
		objDTO.setId(id);
		AlunoAula oldObj = findById(id);
		
		oldObj = newAlunoAula(objDTO);
		
		return repository.save(oldObj);
	}

	private AlunoAula newAlunoAula(AlunoAulaDTO objDTO) {

		Aluno aluno = alunoService.findById(objDTO.getAluno());
		Aula aula = aulaService.findById(objDTO.getAula());
		
		AlunoAula alunoAula = new AlunoAula();
		
		if (objDTO.getId() != null) {
			alunoAula.setId(objDTO.getId());
		}

		alunoAula.setFrequencia(objDTO.getFrequencia());
		alunoAula.setAluno(aluno);
		alunoAula.setAula(aula);

		return alunoAula;
	}

	public void delete(Integer id) {

		repository.deleteById(id);
	}

}
