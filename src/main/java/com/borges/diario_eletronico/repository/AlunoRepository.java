package com.borges.diario_eletronico.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.borges.diario_eletronico.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
	
	// Metodo findByCPF da camada de acesso a dados
	
	/*@Query("SELECT obj FROM Aluno obj WHERE obj.cpf =:cpf")
	Aluno findByCPF(@Param("cpf") String cpf);*/
	//Optional<Aluno> findByCpf(String cpf);

}
