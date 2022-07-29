package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.SerieNivelSubnivel;
import com.borges.diario_eletronico.domain.Turma;
import com.borges.diario_eletronico.domain.dtos.TurmaDTO;
import com.borges.diario_eletronico.repository.TurmaRepository;
import com.borges.diario_eletronico.service.execeptions.DataIntegratyViolationException;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repository;
	@Autowired
	private SerieNivelSubnivelService serieService;

	public Turma findById(Integer id) {
		Optional<Turma> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	
	
	public List<Turma> findAll() {
		//List<Turma> turmasTeste = repository.findAll();
		return repository.findAll();
	}

	public Turma create(TurmaDTO objDTO) {
		return repository.save(newTurma(objDTO));
	}

	public Turma update(Integer id, @Valid TurmaDTO objDTO) {
		
		objDTO.setId(id);
		Turma oldObj = findById(id);
		
		if (oldObj.getAluno().size() > 0) {

			throw new DataIntegratyViolationException("Turma possui alunos, não pode ser Atualizada!");

		} if (oldObj.getProfessorTurmaDisciplinas().size() > 0) {

			throw new DataIntegratyViolationException("Turma possui professor, não pode ser Atulaizada!");

		} 
		

		oldObj = newTurma(objDTO);
		
		return repository.save(oldObj);
	}

	private Turma newTurma(TurmaDTO objDTO) {
		
		SerieNivelSubnivel serie = serieService.findById(objDTO.getSerieNivelSubnivel());
		Turma turma = new Turma();
		
		if (objDTO.getId() != null) {
			turma.setId(objDTO.getId());
		}

		turma.setAnoLetivo(objDTO.getAnoLetivo());
		turma.setSala(objDTO.getSala());
		turma.setSerieNivelSubnivel(serie);

		return turma;
	}

	public void delete(Integer id) {

		Turma obj = findById(id);

		if (obj.getAluno().size() > 0) {

			throw new DataIntegratyViolationException("Turma possui alunos, não pode ser deletada!");

		} if (obj.getProfessorTurmaDisciplinas().size() > 0) {

			throw new DataIntegratyViolationException("Turma possui professor, não pode ser deletad!");

		} 
		repository.deleteById(id);
	}

}
