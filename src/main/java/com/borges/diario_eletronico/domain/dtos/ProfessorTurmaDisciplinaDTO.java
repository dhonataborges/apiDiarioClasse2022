package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.borges.diario_eletronico.domain.ProfessorTurmaDisciplina;
import com.borges.diario_eletronico.domain.enums.Status;

public class ProfessorTurmaDisciplinaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer professor;
	private String nomeProfessor;
	private Integer turma;
	private String descricaoTurma;
	private Integer disciplina;
	private String nomeDisciplina;
	private Integer bimestre;
	private Integer anoLetivo;
	private LocalDate dataAtribuicao;
	private Integer status;
		
	public ProfessorTurmaDisciplinaDTO() {
		super();
	}

	public ProfessorTurmaDisciplinaDTO(ProfessorTurmaDisciplina obj) {
		super();
		this.id = obj.getId();
		this.professor = obj.getProfessor().getId();
		this.nomeProfessor = obj.getProfessor().getNome();
		this.disciplina = obj.getDisciplina().getId();
		this.nomeDisciplina = obj.getDisciplina().getNome();
		this.turma = obj.getTurma().getId();
		this.descricaoTurma = obj.getTurma().getSerieNivelSubnivel().getDescricao();
		this.bimestre = obj.getBimestre();
		this.anoLetivo = obj.getAnoLetivo();
		this.dataAtribuicao = obj.getDataAtribuicao();
		this.status = obj.getStatus().getCodigo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Integer disciplina) {
		this.disciplina = disciplina;
	}
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public Integer getBimestre() {
		return bimestre;
	}

	public void setBimestre(Integer bimestre) {
		this.bimestre = bimestre;
	}

	public Integer getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(Integer anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public LocalDate getDataAtribuicao() {
		return dataAtribuicao;
	}

	public void setDataAtribuicao(LocalDate dataAtribuicao) {
		this.dataAtribuicao = dataAtribuicao;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
			
}
