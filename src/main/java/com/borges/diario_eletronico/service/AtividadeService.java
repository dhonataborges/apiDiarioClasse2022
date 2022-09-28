package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Atividade;
import com.borges.diario_eletronico.domain.Aula;
import com.borges.diario_eletronico.domain.ProfessorTurmaDisciplina;
import com.borges.diario_eletronico.domain.dtos.AtividadeDTO;
import com.borges.diario_eletronico.domain.dtos.AulaDTO;
import com.borges.diario_eletronico.repository.AtividadeRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository repository;
	@Autowired
	private ProfessorTurmaDisciplinaService professorService;

	public Atividade findById(Integer id) {
		Optional<Atividade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Atividade> findAll() {
		return repository.findAll();
	}

	public Atividade create(AtividadeDTO objDTO) {
		return repository.save(newAtividade(objDTO));
	}
	
	public Atividade update(Integer id, @Valid AtividadeDTO objDTO) {
		
		Atividade atividaUpdate = repository.getById(id);
		
		setUpdateAula(atividaUpdate, objDTO);
		
		return repository.saveAndFlush(atividaUpdate);
	}

	public void setUpdateAula(Atividade atividade, AtividadeDTO objDTO) {
		
		ProfessorTurmaDisciplina professorTurmaDisciplina = professorService.findById(objDTO.getDisciplina());
		
		atividade.setDataCriacao(objDTO.getDataCriacao());
		atividade.setDataEntrega(objDTO.getDataEntrega());
		atividade.setNotaMaxima(objDTO.getNotaMaxima());
		atividade.setDescricao(objDTO.getDescricao());
		atividade.setTipo(objDTO.getTipo());
		atividade.setProfessorTurmaDisciplina(professorTurmaDisciplina);
		
	}

	private Atividade newAtividade(AtividadeDTO objDTO) {
		
		Atividade atividade = new Atividade();
		ProfessorTurmaDisciplina professorTurmaDisciplina = professorService.findById(objDTO.getDisciplina());
			
		if (objDTO.getId() != null) {
			atividade.setId(objDTO.getId());
		}

		atividade.setDataCriacao(objDTO.getDataCriacao());
		atividade.setDataEntrega(objDTO.getDataEntrega());
		atividade.setNotaMaxima(objDTO.getNotaMaxima());
		atividade.setDescricao(objDTO.getDescricao());
		atividade.setTipo(objDTO.getTipo());
		atividade.setProfessorTurmaDisciplina(professorTurmaDisciplina);

		return atividade;
	}

	public void delete(Integer id) {

		Atividade obj = findById(id);

		/* if (obj.getProfessorTurmaDisciplina().size() > 0) {

			throw new DataIntegratyViolationException("Atividade possui professor! N ão pode ser deletado!");

		} */
		repository.deleteById(id);
	}

}
