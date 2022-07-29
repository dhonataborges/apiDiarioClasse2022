/*package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Professor;
import com.borges.diario_eletronico.domain.ProfessorTurma;
import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.dtos.ProfessorTurmaDTO;
import com.borges.diario_eletronico.domain.enums.Status;
import com.borges.diario_eletronico.repository.ProfessorTurmaRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class ProfessorTurmaService{
	
	@Autowired
	private ProfessorTurmaRepository repository;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private TurmaService turmaService;
	
	public ProfessorTurma findById(Integer id) {		
		Optional<ProfessorTurma> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<ProfessorTurma> findAll() {
		return repository.findAll();
	}

	public ProfessorTurma create(ProfessorTurmaDTO objDTO) {
		return repository.save(newProfessorTurma(objDTO));
	}
	
	public ProfessorTurma update(Integer id, @Valid ProfessorTurmaDTO objDTO) {
		objDTO.setId(id);
		ProfessorTurma oldObj = findById(id);
		oldObj = newProfessorTurma(objDTO);
		return repository.save(oldObj);
	}
	
	private ProfessorTurma newProfessorTurma(ProfessorTurmaDTO obj) {
		
		Professor professor = professorService.findById(obj.getProfessor());
		Turma turma = turmaService.findById(obj.getTurma());	
		
		ProfessorTurma professorTurma = new ProfessorTurma();
		
		if(obj.getId() != null) {
			professorTurma.setId(obj.getId());
		}
		
		professorTurma.setTurma(turma);
		professorTurma.setProfessor(professor);;
		professorTurma.setDataAtribuicao(obj.getDataAtribuicao());
		professorTurma.setStatus(Status.toEnum(obj.getStatus()));
		
		return professorTurma;
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}*/
