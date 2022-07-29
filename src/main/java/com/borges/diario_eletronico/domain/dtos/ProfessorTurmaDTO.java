/*package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.borges.diario_eletronico.domain.ProfessorTurma;

public class ProfessorTurmaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer turma;
	private String descricaoTurma;
	private Integer professor;
	private String nomeProfessor;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dataAtribuicao;
	private Integer status;
	
	public ProfessorTurmaDTO() {
		super();
	}

	public ProfessorTurmaDTO(ProfessorTurma obj) {
		super();
		this.id = obj.getId();
		this.turma = obj.getTurma().getId();
		this.descricaoTurma = obj.getTurma().getSerieNivelSubnivel().getDescricao().toString();
		this.professor = obj.getProfessor().getId();
		this.nomeProfessor = obj.getProfessor().getNome();
		this.dataAtribuicao = obj.getDataAtribuicao();
		this.status = obj.getStatus().getCodigo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTurma() {
		return turma;
	}

	public void setTurma(Integer turma) {
		this.turma = turma;
	}

	public String getDescricaoTurma() {
		return descricaoTurma;
	}

	public void setDescricaoTurma(String descricaoTurma) {
		this.descricaoTurma = descricaoTurma;
	}

	public Integer getProfessor() {
		return professor;
	}

	public void setProfessor(Integer professor) {
		this.professor = professor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public LocalDate getDataAtribuicao() {
		return dataAtribuicao;
	}

	public void setDataAtribuicao(LocalDate dataAtribuicao) {
		this.dataAtribuicao = dataAtribuicao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
		
}
*/