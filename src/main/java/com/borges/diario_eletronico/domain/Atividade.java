package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "atividade")
public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	@Column(name = "data_entrega")
	private LocalDate dataEntrega;

	@Column(name = "nota_maxima")
	private Integer notaMaxima;

	private String descricao;
	private String tipo;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "professor_turma_disciplina_id")
	private ProfessorTurmaDisciplina professorTurmaDisciplina;
	
	@Column(unique = true)
	@OneToMany(mappedBy = "atividade", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private List<AlunoAtividade> alunoAtividade;

	public Atividade() {
		super();
	}

	public Atividade(Integer id, LocalDate dataCriacao, LocalDate dataEntrega, Integer notaMaxima, String descricao,
			Integer bimestre, String tipo, ProfessorTurmaDisciplina professorTurmaDisciplina) {
		super();
		this.id = id;
		this.setDataCriacao(LocalDate.now());
		this.setDataEntrega(LocalDate.now());
		this.notaMaxima = notaMaxima;
		this.descricao = descricao;
		this.tipo = tipo;
		this.professorTurmaDisciplina = professorTurmaDisciplina;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		return Objects.equals(id, other.id);
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

	public ProfessorTurmaDisciplina getProfessorTurmaDisciplina() {
		return professorTurmaDisciplina;
	}

	public void setProfessorTurmaDisciplina(ProfessorTurmaDisciplina professorTurmaDisciplina) {
		this.professorTurmaDisciplina = professorTurmaDisciplina;
	}

	public List<AlunoAtividade> getAlunoAtividade() {
		return alunoAtividade;
	}

	public void setAlunoAtividade(List<AlunoAtividade> alunoAtividade) {
		this.alunoAtividade = alunoAtividade;
	}

}
