package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;

import com.borges.diario_eletronico.domain.AlunoAtividade;

public class AlunoAtividadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer nota;
	private Integer aluno;
	private String nomeAluno;
	private Integer atividade;
	private String nomeAtividadeTipo;

	public AlunoAtividadeDTO() {
		super();
	}

	public AlunoAtividadeDTO(AlunoAtividade obj) {
		super();
		this.id = obj.getId();
		this.nota = obj.getNota();
		this.aluno = obj.getAluno().getId();
		this.nomeAluno = obj.getAluno().getNome();
		this.atividade = obj.getAtividade().getId();
		this.nomeAtividadeTipo = obj.getAtividade().getTipo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Integer getAluno() {
		return aluno;
	}

	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Integer getAtividade() {
		return atividade;
	}

	public void setAtividade(Integer atividade) {
		this.atividade = atividade;
	}

	public String getNomeAtividadeTipo() {
		return nomeAtividadeTipo;
	}

	public void setNomeAtividadeTipo(String nomeAtividadeTipo) {
		this.nomeAtividadeTipo = nomeAtividadeTipo;
	}

}
