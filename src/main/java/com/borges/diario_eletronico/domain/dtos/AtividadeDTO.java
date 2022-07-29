package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.borges.diario_eletronico.domain.Atividade;

public class AtividadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dataCriacao;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dataEntrega;
	
	private Integer notaMaxima;
	private String descricao;
	private String tipo;
	
	private Integer disciplina;
	private String nomeDisciplina;
	
	public AtividadeDTO() {
		super();
	}

	public AtividadeDTO(Atividade obj) {
		super();
		this.id = obj.getId();
		this.dataCriacao = obj.getDataCriacao();
		this.dataEntrega = obj.getDataEntrega();
		this.notaMaxima = obj.getNotaMaxima();
		this.descricao = obj.getDescricao();
		this.tipo = obj.getTipo();
		this.disciplina = obj.getProfessorTurmaDisciplina().getDisciplina().getId();
		this.nomeDisciplina = obj.getProfessorTurmaDisciplina().getDisciplina().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Integer getNotaMaxima() {
		return notaMaxima;
	}

	public void setNotaMaxima(Integer notaMaxima) {
		this.notaMaxima = notaMaxima;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

}
