package com.borges.diario_eletronico.service;

import org.springframework.stereotype.Service;

@Service
public class DBService {
	
	//LocalDateTime agora = LocalDateTime.now();
	
	/*@Autowired
	private AlunoRepository alunoRepository;*/
	
	/*@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private ProfessorRepository profissionalRepository;
		
	/*@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private SerieNivelSubnivelRepository serieRepository;
	
	@Autowired
	private ProfessorTurmaRepository professorTurmaRepository;*/
	
	/*@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() throws ParseException {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int ano = localDate.getYear();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime dateTime = LocalDateTime.parse("2016-09-21 13:43:27.000", formatter);*/
		
		/*Aluno a1 = new Aluno(null, "João Borges", sdf.parse("25/06/1995"),"masculino", "133.120.446-18", "mg19.599.003", "Maria Aparecida do Santos",
							"(38)99927-6907", "rua: batista", "urbana", "1° serie");*/
			
		/*Professor p1 = new Professor(null, "Mateus Oliver",sdf.parse("25/06/1995"), "masculino","787.352.100-10", "mg19.599.003", 
							"(38)99927-6907",  "rua: batista", "urbana","admin@gmail.com", encoder.encode("123"));
		p1.addPerfil(Perfil.ADMIN);
		
		
		Professor p2 = new Professor(null, "Joana Marques",sdf.parse("25/06/1995"), "feminino","957.443.730-20", "mg19.599.003", 
				"(38)99927-6907",  "rua: batista","rural","borges@gmail.com", encoder.encode("123"));
		p2.addPerfil(Perfil.PROFESSOR);
		
		/*SerieNivelSubnivel s1 = new SerieNivelSubnivel(null, 2, 4, "Segunda Serie");
		SerieNivelSubnivel s2 = new SerieNivelSubnivel(null, 1, 5, "Primeira Serie");
		
		Disciplina d1 = new Disciplina(null, "Português", "A Língua Portuguesa como fonte de comunicação ",s2);	
	   
		Turma t1 = new Turma(null, ano, 520, s1);
		
		ProfessorTurma pf1 = new ProfessorTurma(null, t1, p2, sdf.parse("25/06/1995"), true);
	    

		serieRepository.saveAll(Arrays.asList(s1, s2));
		
        disciplinaRepository.saveAll(Arrays.asList(d1));
			    
	    alunoRepository.saveAll(Arrays.asList(a1));
	    
		turmaRepository.saveAll(Arrays.asList(t1));
				
		professorTurmaRepository.saveAll(Arrays.asList(pf1));*/

	  /*  profissionalRepository.saveAll(Arrays.asList(p1,p2));

	}*/

	
}