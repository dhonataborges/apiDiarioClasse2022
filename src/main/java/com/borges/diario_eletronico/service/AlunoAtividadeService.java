package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.AlunoAtividade;
import com.borges.diario_eletronico.domain.Atividade;
import com.borges.diario_eletronico.domain.dtos.AlunoAtividadeDTO;
import com.borges.diario_eletronico.repository.AlunoAtividadeRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class AlunoAtividadeService {

	@Autowired
	private AlunoAtividadeRepository repository;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private AtividadeService atividadeService;

	public AlunoAtividade findById(Integer id) {
		Optional<AlunoAtividade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<AlunoAtividade> findAll() {
		return repository.findAll();
	}

	public AlunoAtividade create(AlunoAtividadeDTO objDTO) {
		return repository.save(newAlunoAtividade(objDTO));
	}

	public AlunoAtividade update(Integer id, @Valid AlunoAtividadeDTO objDTO) {

		objDTO.setId(id);
		AlunoAtividade oldObj = findById(id);

		oldObj = newAlunoAtividade(objDTO);

		return repository.save(oldObj);
	}

	private AlunoAtividade newAlunoAtividade(AlunoAtividadeDTO objDTO) {

		Aluno aluno = alunoService.findById(objDTO.getAluno());
		Atividade atividade = atividadeService.findById(objDTO.getAtividade());
		
		AlunoAtividade alunoAtividade = new AlunoAtividade();

		if (objDTO.getId() != null) {
			alunoAtividade.setId(objDTO.getId());
		}

		alunoAtividade.setNota(objDTO.getNota());
		alunoAtividade.setAluno(aluno);
		alunoAtividade.setAtividade(atividade);

		return alunoAtividade;
	}

	public void delete(Integer id) {
		
		repository.deleteById(id);
	}

}
