package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aula")
public class Aula implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate data;
	
	@Column(name = "hora_inicio")
	private LocalTime horaInicio;
	
	@Column(name = "hora_fim")
	private LocalTime horaFim;
	
	private String conteudo;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "professor_turma_disciplina_id")
	private ProfessorTurmaDisciplina professorTurmaDisciplina;
	
	@Column(unique = true)
	@OneToMany(mappedBy = "aula", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private List<AlunoAula> alunoAula;
		
	public Aula() {
		super();
	}

	public Aula(Integer id, LocalDate data, LocalTime horaInicio, LocalTime horaFim, String conteudo,
			ProfessorTurmaDisciplina professorTurmaDisciplina) {
		super();
		this.id = id;
		this.setData(LocalDate.now());
		this.setHoraInicio(LocalTime.now());
		this.setHoraFim(LocalTime.now());
		this.conteudo = conteudo;
		this.professorTurmaDisciplina = professorTurmaDisciplina;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public ProfessorTurmaDisciplina getProfessorTurmaDisciplina() {
		return professorTurmaDisciplina;
	}

	public void setProfessorTurmaDisciplina(ProfessorTurmaDisciplina professorTurmaDisciplina) {
		this.professorTurmaDisciplina = professorTurmaDisciplina;
	}

	public List<AlunoAula> getAlunoAula() {
		return alunoAula;
	}

	public void setAlunoAula(List<AlunoAula> alunoAula) {
		this.alunoAula = alunoAula;
	}
	
}
