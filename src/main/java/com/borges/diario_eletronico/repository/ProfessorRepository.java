package com.borges.diario_eletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borges.diario_eletronico.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

	///Optional<Professor> findByEmail(String email);

}
