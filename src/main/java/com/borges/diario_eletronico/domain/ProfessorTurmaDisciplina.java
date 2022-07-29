package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.borges.diario_eletronico.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "professor_turma_disciplina")
public class ProfessorTurmaDisciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "professor_turma_id") private ProfessorTurma
	 * professorTurma;
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "turma_id")
	private Turma turma;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "professor_id")
	private Professor professor;

	private LocalDate dataAtribuicao;

	private Integer status;

	private Integer bimestre;

	@Column(name = "ano_letivo")
	private Integer anoLetivo;

	@JsonIgnore
	@OneToMany(mappedBy = "professorTurmaDisciplina", cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Aula> aula;

	@JsonIgnore
	@OneToMany(mappedBy = "professorTurmaDisciplina", cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Atividade> atividade;

	public ProfessorTurmaDisciplina() {
		super();
	}

	public ProfessorTurmaDisciplina(Integer id, Professor professor, Turma turma, Disciplina disciplina, Integer bimestre,
			Integer anoLetivo, LocalDate dataAtribuicao, Status status) {
		super();
		this.id = id;
		this.professor = professor;
		this.turma = turma;
		this.disciplina = disciplina;
		this.bimestre = bimestre;
		this.anoLetivo = anoLetivo;
		this.setDataAtribuicao(LocalDate.now());
		this.status = (status == null) ? 0 : status.getCodigo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
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

	public void setStatus(Status status) {
		this.status = status.getCodigo();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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

	public List<Aula> getAula() {
		return aula;
	}

	public void setAula(List<Aula> aula) {
		this.aula = aula;
	}

	public List<Atividade> getAtividade() {
		return atividade;
	}

	public void setAtividade(List<Atividade> atividade) {
		this.atividade = atividade;
	}

}
