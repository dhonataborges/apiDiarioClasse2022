package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String ementa;
	
	@OneToMany(mappedBy = "disciplina", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private List<ProfessorTurmaDisciplina> professorTurmaDisciplina;
	
	@OneToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "serieNivelSubnivel_id")
    private SerieNivelSubnivel serieNivelSubnivel;
 

	public Disciplina() {
		super();
	}
	
	public Disciplina(Integer id, String nome, String ementa, SerieNivelSubnivel serieNivelSubnivel) {
		super();
		this.id = id;
		this.nome = nome;
		this.ementa = ementa;
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
		Disciplina other = (Disciplina) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public List<ProfessorTurmaDisciplina> getProfessorTurmaDisciplina() {
		return professorTurmaDisciplina;
	}

	public void setProfessorTurmaDisciplina(List<ProfessorTurmaDisciplina> professorTurmaDisciplina) {
		this.professorTurmaDisciplina = professorTurmaDisciplina;
	}

	public SerieNivelSubnivel getSerieNivelSubnivel() {
		return serieNivelSubnivel;
	}

	public void setSerieNivelSubnivel(SerieNivelSubnivel serieNivelSubnivel) {
		this.serieNivelSubnivel = serieNivelSubnivel;
	}
	
}
