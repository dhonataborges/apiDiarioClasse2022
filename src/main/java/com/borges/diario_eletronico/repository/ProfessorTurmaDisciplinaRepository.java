package com.borges.diario_eletronico.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.borges.diario_eletronico.domain.Professor;
import com.borges.diario_eletronico.domain.ProfessorTurmaDisciplina;

@Repository
public interface ProfessorTurmaDisciplinaRepository extends JpaRepository<ProfessorTurmaDisciplina, Integer> {
	/*@Query("select * ProfessorTurmaDisciplina p inner join p.professor pro where pro.email= :admin@gmail.com")
	Optional<ProfessorTurmaDisciplina> buscarProfessorTurma(@Param("professor") Integer professor);*/
		
	List<ProfessorTurmaDisciplina> findByProfessor(Professor professor);
	
	@Query(value = "SELECT t.turma_id, t.disciplina_id FROM professor_turma_disciplina t, turma tm, disciplina d "
			+ "WHERE t.turma_id = tm.id AND t.disciplina_id = d.id", nativeQuery = true)
	List<ProfessorTurmaDisciplina> findAllTurmas();
}
