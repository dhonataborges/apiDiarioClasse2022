package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.borges.diario_eletronico.domain.Professor;
import com.borges.diario_eletronico.domain.enums.Perfil;

public class ProfessorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	// @NotBlank(message = "Campo NOME não pode ser vasio!")
	private String nome;

	// @NotNull(message = "Campo NASCIMENTO não pode ser vasio!")
	/*
	 * @DateTimeFormat(pattern = "dd/MM/yyyy")
	 * 
	 * @Temporal(TemporalType.DATE)
	 * 
	 * @Column(name = "nascimento") private LocalDate nascimento;
	 * 
	 * //@NotBlank(message = "Campo SEXO não pode ser vasio!") private String sexo;
	 * 
	 * 
	 * //@NotBlank(message = "Campo CPF não pode ser vasio!") private String cpf;
	 * 
	 * //@NotBlank(message = "Campo RG não pode ser vasio!")
	 * 
	 * @Length(max = 12, message = "O RG não pode ser maior que {max} caracteres!")
	 * 
	 * @Column(name = "rg", length = 12, nullable = false) private String rg;
	 * 
	 * //@NotBlank(message = "Campo TELEFONE não pode ser vasio!") private String
	 * telefone;
	 * 
	 * //@NotBlank(message = "Campo ENDEREÇO não pode ser vasio!") private String
	 * endereco;
	 * 
	 * //@NotBlank(message = "Campo ZONA não pode ser vasio!") private String zona;
	 */

	@NotNull(message = "O campo E-MAIL é requerido")
	protected String email;

	@NotNull(message = "O campo SENHA é requerido")
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();

	public ProfessorDTO() {
		super();
		addPerfil(Perfil.PROFESSOR);
	}

	public ProfessorDTO(Professor obj) {

		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		/*
		 * this.nascimento = obj.getNascimento(); this.sexo = obj.getSexo(); this.cpf =
		 * obj.getCpf(); this.rg = obj.getRg(); this.telefone = obj.getTelefone();
		 * this.endereco = obj.getEndereco(); this.zona = obj.getZona();
		 */
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		addPerfil(Perfil.PROFESSOR);
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
