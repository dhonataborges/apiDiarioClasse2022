package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.borges.diario_eletronico.domain.enums.Perfil;

@Entity
@Table(name = "professor")
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String nome;
	/*
	 * protected LocalDate nascimento; protected String sexo;
	 * 
	 * @CPF protected String cpf; protected String rg; protected String telefone;
	 * protected String endereco; protected String zona;
	 */

	// @Column(unique = true)
	protected String email;
	protected String senha;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	protected Set<Integer> perfis = new HashSet<>();

	public Pessoa() {
		super();
	}

	public Pessoa(Integer id, String nome, /*
											 * LocalDate nascimento, String sexo, String cpf, String rg, String
											 * telefone, String endereco, String zona,
											 */ String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		/*
		 * this.setNascimento(LocalDate.now()); this.sexo = sexo; this.cpf = cpf;
		 * this.rg = rg; this.telefone = telefone; this.endereco = endereco; this.zona =
		 * zona;
		 */
		this.email = email;
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	/*
	 * public LocalDate getNascimento() { return nascimento; }
	 * 
	 * public void setNascimento(LocalDate nascimento) { this.nascimento =
	 * nascimento; }
	 * 
	 * public String getSexo() { return sexo; }
	 * 
	 * public void setSexo(String sexo) { this.sexo = sexo; }
	 * 
	 * public String getCpf() { return cpf; }
	 * 
	 * public void setCpf(String cpf) { this.cpf = cpf; }
	 * 
	 * public String getRg() { return rg; }
	 * 
	 * public void setRg(String rg) { this.rg = rg; }
	 * 
	 * public String getTelefone() { return telefone; }
	 * 
	 * public void setTelefone(String telefone) { this.telefone = telefone; }
	 * 
	 * public String getEndereco() { return endereco; }
	 * 
	 * public void setEndereco(String endereco) { this.endereco = endereco; }
	 * 
	 * public String getZona() { return zona; }
	 * 
	 * public void setZona(String zona) { this.zona = zona; }
	 */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

}
