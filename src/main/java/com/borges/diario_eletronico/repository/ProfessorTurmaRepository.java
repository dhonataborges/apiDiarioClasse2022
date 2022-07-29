/*package com.borges.diario_eletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.borges.diario_eletronico.domain.ProfessorTurma;

@Repository
public interface ProfessorTurmaRepository extends JpaRepository<ProfessorTurma, Integer> {
	
	/*@Query(value = "SELECT * FROM `professor_turma` WHERE professor_id = turma_id", nativeQuery = true)
	List<ProfessorTurma> findAllTurmas();*/
	
/*	@Query("SELECT obj FROM ProfessorTurma obj WHERE obj.professor =:professor")
	ProfessorTurma findByIdTest(@Param("professor") Professor professor);*/
	
	/*Optional<ProfessorTurma> findByIdProf(Integer professor);
	Optional<ProfessorTurma> findByIdTurma(Integer turma);
}
*/