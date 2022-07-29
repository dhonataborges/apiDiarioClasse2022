package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "anoLetivo")
	private Integer anoLetivo;
	
	private Integer sala;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "serie_nivel_subnivel_id")
	private SerieNivelSubnivel serieNivelSubnivel;
	
	@Column(unique = true)
	@OneToMany(mappedBy = "turma", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ProfessorTurmaDisciplina> professorTurmaDisciplinas;
	
	@Column(unique = true)
	@OneToMany(mappedBy = "turma", cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Aluno> aluno;
			
	public Turma() {
		super();
	}

	public Turma(Integer id, Integer anoLetivo, Integer sala, SerieNivelSubnivel serieNivelSubnivel) {
		super();
		this.id = id;
		this.anoLetivo = anoLetivo;
		this.sala = sala;
		this.serieNivelSubnivel = serieNivelSubnivel;
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
		Turma other = (Turma) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(Integer anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public SerieNivelSubnivel getSerieNivelSubnivel() {
		return serieNivelSubnivel;
	}

	public void setSerieNivelSubnivel(SerieNivelSubnivel serieNivelSubnivel) {
		this.serieNivelSubnivel = serieNivelSubnivel;
	}

	public List<ProfessorTurmaDisciplina> getProfessorTurmaDisciplinas() {
		return professorTurmaDisciplinas;
	}

	public void setProfessorTurmaDisciplina(List<ProfessorTurmaDisciplina> professorTurmaDisciplinas) {
		this.professorTurmaDisciplinas = professorTurmaDisciplinas;
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}
			
}
