package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Disciplina;
import com.borges.diario_eletronico.domain.Professor;
import com.borges.diario_eletronico.domain.ProfessorTurmaDisciplina;
import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.dtos.ProfessorTurmaDisciplinaDTO;
import com.borges.diario_eletronico.domain.enums.Status;
import com.borges.diario_eletronico.repository.ProfessorTurmaDisciplinaRepository;
import com.borges.diario_eletronico.service.execeptions.DataIntegratyViolationException;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class ProfessorTurmaDisciplinaService{
	
	@Autowired
	private ProfessorTurmaDisciplinaRepository repository;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	public ProfessorTurmaDisciplina findById(Integer id) {
		Optional<ProfessorTurmaDisciplina> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<ProfessorTurmaDisciplina> findAll() {			
		return repository.findAll();
	}

	public ProfessorTurmaDisciplina create(ProfessorTurmaDisciplinaDTO objDTO) {
		return repository.save(newProfessorTurmaDisciplina(objDTO));
	}
	
	public ProfessorTurmaDisciplina update(Integer id, @Valid ProfessorTurmaDisciplinaDTO objDTO) {
		objDTO.setId(id);
		ProfessorTurmaDisciplina oldObj = findById(id);
		oldObj = newProfessorTurmaDisciplina(objDTO);
		return repository.save(oldObj);
	}
	
	private ProfessorTurmaDisciplina newProfessorTurmaDisciplina(ProfessorTurmaDisciplinaDTO objDTO) {
		
		Professor prof = professorService.findById(objDTO.getProfessor());
		Turma turma = turmaService.findById(objDTO.getTurma());
		Disciplina disciplina = disciplinaService.findById(objDTO.getDisciplina());
		
		ProfessorTurmaDisciplina professorTurmaDisciplina = new ProfessorTurmaDisciplina();
		
		if(objDTO.getId() != null) {
			professorTurmaDisciplina.setId(objDTO.getId());
		}
		
		professorTurmaDisciplina.setProfessor(prof);
		professorTurmaDisciplina.setTurma(turma);
		professorTurmaDisciplina.setDisciplina(disciplina);;
		professorTurmaDisciplina.setBimestre(objDTO.getBimestre());
		professorTurmaDisciplina.setAnoLetivo(objDTO.getAnoLetivo());
		professorTurmaDisciplina.setDataAtribuicao(objDTO.getDataAtribuicao());
		professorTurmaDisciplina.setStatus(Status.toEnum(objDTO.getStatus().getCodigo()));
		
		return professorTurmaDisciplina;
	}
	
	public void delete(Integer id) {
		
		ProfessorTurmaDisciplina obj = findById(id);

		if (obj.getAula().size() > 0) {

			throw new DataIntegratyViolationException("Professor possui aulas, não pode ser deletado!");

		}
		repository.deleteById(id);
	}
	
}
