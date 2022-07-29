/*package com.borges.diario_eletronico.domain;

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

import com.borges.diario_eletronico.domain.enums.Status;

@Entity
@Table(name = "professor_turma")
public class ProfessorTurma implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "professor_id")
	private Professor professor;

	private LocalDate dataAtribuicao;
	
	private Status status;
	
	@Column(unique = true)
	@OneToMany(mappedBy = "professorTurma", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private List<ProfessorTurmaDisciplina> professorTurmaDisciplina;
		
	public ProfessorTurma() {
		super();
	}

	public ProfessorTurma(Integer id, Turma turma, Professor professor, LocalDate dataAtribuicao, Status status) {
		super();
		this.id = id;
		this.turma = turma;
		this.professor = professor;
		this.setDataAtribuicao(LocalDate.now());
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public LocalDate getDataAtribuicao() {
		return dataAtribuicao;
	}

	public void setDataAtribuicao(LocalDate dataAtribuicao) {
		this.dataAtribuicao = dataAtribuicao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ProfessorTurmaDisciplina> getProfessorTurmaDisciplina() {
		return professorTurmaDisciplina;
	}

	public void setProfessorTurmaDisciplina(List<ProfessorTurmaDisciplina> professorTurmaDisciplina) {
		this.professorTurmaDisciplina = professorTurmaDisciplina;
	}
		
}*/
