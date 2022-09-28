package com.borges.diario_eletronico.service;

/*import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;*/
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Pessoa;
import com.borges.diario_eletronico.domain.Professor;
import com.borges.diario_eletronico.domain.dtos.ProfessorDTO;
import com.borges.diario_eletronico.repository.DisciplinaRepository;
import com.borges.diario_eletronico.repository.PessoaRepository;
import com.borges.diario_eletronico.repository.ProfessorRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;
//import com.google.gson.Gson;

@Service
public class ProfessorService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	ProfessorRepository professorRepository;

	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	/**
	 * Buscar Profissional pelo ID
	 */
	public Professor findById(Integer id) {

		Optional<Professor> obj = professorRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Professor.class.getName()));
	}

	/*
	 * Busca todos os Profissional da base de dados
	 */
	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	/*
	 * Cria um Profissional
	 */
	public Professor create(ProfessorDTO objDTO) {
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCpfEEmail(objDTO);
		return professorRepository.save(newProfissional(objDTO));
	}

	/*
	 * Atualizar um Profissional
	 */
	public Professor update(Integer id, @Valid ProfessorDTO objDTO) {
		objDTO.setId(id);
		Professor oldObj = findById(id);
		
		if(!objDTO.getSenha().equals(oldObj.getSenha())) {
			objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		}
		
		validaPorCpfEEmail(objDTO);
		oldObj = newProfissional(objDTO);
		return professorRepository.save(oldObj);
	}

	private Professor newProfissional(ProfessorDTO obj) {

		Professor profissional = new Professor();

		if (obj.getId() != null) {
			profissional.setId(obj.getId());
		}

		profissional.setNome(obj.getNome());
		/*profissional.setNascimento(obj.getNascimento());
		profissional.setSexo(obj.getSexo());
		profissional.setCpf(obj.getCpf());
		profissional.setRg(obj.getRg());
		profissional.setTelefone(obj.getTelefone());
		profissional.setEndereco(obj.getEndereco());
		profissional.setZona(obj.getZona());*/
		profissional.setEmail(obj.getEmail());
		profissional.setSenha(obj.getSenha());

		return profissional;
	}

	/*
	 * Delete um Profissional pelo ID
	 */
	public void delete(Integer id) {
		
		professorRepository.deleteById(id);

	}

	/*
	 * Busca o Aluno pelo CPF
	 */
	private void validaPorCpfEEmail(ProfessorDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByEmail(objDTO.getEmail());
	
		/*if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}*/

		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}

}
