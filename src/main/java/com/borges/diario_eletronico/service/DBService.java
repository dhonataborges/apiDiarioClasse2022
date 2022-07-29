package com.borges.diario_eletronico.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Professor;
import com.borges.diario_eletronico.domain.enums.Perfil;
import com.borges.diario_eletronico.repository.ProfessorRepository;

@Service
public class DBService {
	
	@Autowired
	private ProfessorRepository profissionalRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() throws ParseException {
			
		Professor p1 = new Professor(null, "Mateus Oliver", "admin@gmail.com", encoder.encode("123"));
		p1.addPerfil(Perfil.ADMIN);
		
		
		Professor p2 = new Professor(null, "Joana Marques","borges@gmail.com", encoder.encode("123"));
		p2.addPerfil(Perfil.PROFESSOR);
		
		profissionalRepository.saveAll(Arrays.asList(p1,p2));

	}

	
}