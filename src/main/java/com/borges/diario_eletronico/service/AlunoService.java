package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.dtos.AlunoDTO;
import com.borges.diario_eletronico.repository.AlunoRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private TurmaService turmaService;

	public Aluno findById(Integer id) {
		Optional<Aluno> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Aluno> findAll() {
		return repository.findAll();
	}

	public Aluno create(AlunoDTO objDTO) {
		return repository.save(newAluno(objDTO));
	}

	public Aluno update(Integer id, @Valid AlunoDTO objDTO) {

		objDTO.setId(id);
		Aluno oldObj = findById(id);
		//validaPorCpf(objDTO);
		oldObj = newAluno(objDTO);

		return repository.save(oldObj);
	}

	private Aluno newAluno(AlunoDTO objDTO) {

		Turma turma = turmaService.findById(objDTO.getTurma());
		Aluno aluno = new Aluno();

		if (objDTO.getId() != null) {
			aluno.setId(objDTO.getId());
		}

		aluno.setNome(objDTO.getNome());
		/*
		 * aluno.setNascimento(objDTO.getNascimento()); aluno.setSexo(objDTO.getSexo());
		 * aluno.setCpf(objDTO.getCpf()); aluno.setRg(objDTO.getRg());
		 * aluno.setResponsavel(objDTO.getResponsavel());
		 * aluno.setTelefone(objDTO.getTelefone());
		 * aluno.setEndereco(objDTO.getEndereco()); aluno.setZona(objDTO.getZona());
		 */
		aluno.setTurma(turma);

		return aluno;
	}

	public void delete(Integer id) {

		repository.deleteById(id);
	}

	/*
	 * private void validaPorCpf(AlunoDTO objDTO) { Optional<Aluno> obj =
	 * repository.findByCpf(objDTO.getCpf()); if(obj.isPresent() &&
	 * obj.get().getId() != objDTO.getId()) { throw new
	 * DataIntegrityViolationException("CPF já cadastrado no sistema!"); }
	 * 
	 * }
	 */

}