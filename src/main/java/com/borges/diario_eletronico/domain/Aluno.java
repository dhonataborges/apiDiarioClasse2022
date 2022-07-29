package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	/*private LocalDate nascimento;
	private String sexo;
	private String cpf;	
	private String rg;
	private String responsavel;
	private String telefone;
	private String endereco;
	private String zona;*/
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "turma_id")	
	private Turma turma;
	
	@OneToMany(mappedBy = "aluno", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@Fetch(value = FetchMode.SUBSELECT)
	private List<AlunoAtividade> alunoAtividade;
	
	@OneToMany(mappedBy = "aluno", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@Fetch(value = FetchMode.SUBSELECT)
	private List<AlunoAula> alunoAula;
			
	public Aluno() {
		super();
	}
	public Aluno(Integer id, String nome/*, LocalDate nascimento, String sexo, String cpf, String rg, String responsavel, String telefone,
			String endereco, String zona*/, Turma turma) {
		super();
		this.id = id;
		this.nome = nome;
		/*this.setNascimento(LocalDate.now());
		this.sexo = sexo;
		this.cpf = cpf;
		this.rg = rg;
		this.responsavel = responsavel;
		this.telefone = telefone;
		this.endereco = endereco;		
		this.zona = zona;*/
		this.turma = turma;
	}
	
	/*@Override
	public int hashCode() {
		return Objects.hash(cpf, id, rg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id) && Objects.equals(rg, other.rg);
	}*/

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

	/*public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	*/
	public List<AlunoAtividade> getAlunoAtividade() {
		return alunoAtividade;
	}
	public void setAlunoAtividade(List<AlunoAtividade> alunoAtividade) {
		this.alunoAtividade = alunoAtividade;
	}
	
	public List<AlunoAula> getAlunoAula() {
		return alunoAula;
	}
	public void setAlunoAula(List<AlunoAula> alunoAula) {
		this.alunoAula = alunoAula;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
			
}
