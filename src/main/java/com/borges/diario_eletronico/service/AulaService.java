package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aula;
import com.borges.diario_eletronico.domain.ProfessorTurmaDisciplina;
import com.borges.diario_eletronico.domain.dtos.AulaDTO;
import com.borges.diario_eletronico.repository.AulaRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class AulaService {

	@Autowired
	private AulaRepository repository;
	@Autowired
	private ProfessorTurmaDisciplinaService professorService;

	public Aula findById(Integer id) {
		Optional<Aula> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Aula> findAll() {
		return repository.findAll();
	}

	public Aula create(AulaDTO objDTO) {
		return repository.save(newAula(objDTO));
	}

	public Aula update(Integer aulaId, @Valid AulaDTO aulaDTO) {
		
		Aula aulaUpdate = repository.getById(aulaId);
		
		setUpdateAula(aulaUpdate, aulaDTO);
		
		return repository.saveAndFlush(aulaUpdate);
	}

	private void setUpdateAula(Aula aula , AulaDTO objDTO) {
		
		ProfessorTurmaDisciplina professorTurmaDisciplina = professorService.findById(objDTO.getDisciplina());		

		aula.setData(objDTO.getData());
		aula.setHoraInicio(objDTO.getHoraInicio());
		aula.setHoraFim(objDTO.getHoraFim());
		aula.setConteudo(objDTO.getConteudo());
		aula.setProfessorTurmaDisciplina(professorTurmaDisciplina);

	}
	
	private Aula newAula(AulaDTO objDTO) {
		
		Aula aula = new Aula();
		ProfessorTurmaDisciplina professorTurmaDisciplina = professorService.findById(objDTO.getDisciplina());		

		
		if (objDTO.getId() != null) {
			aula.setId(objDTO.getId());
		}
		
		aula.setData(objDTO.getData());
		aula.setHoraInicio(objDTO.getHoraInicio());
		aula.setHoraFim(objDTO.getHoraFim());
		aula.setConteudo(objDTO.getConteudo());
		aula.setProfessorTurmaDisciplina(professorTurmaDisciplina);
		
		return aula;

	}

	public void delete(Integer id) {

		Aula obj = findById(id);

		/* if (obj.getProfessorTurmaDisciplina().size() > 0) {

			throw new DataIntegratyViolationException("Aula possui professor, não pode ser deletad!");

		} */
		repository.deleteById(id);
	}

}
