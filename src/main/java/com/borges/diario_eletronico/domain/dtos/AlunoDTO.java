package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.borges.diario_eletronico.domain.Aluno;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotBlank(message = "Campo NOME não pode ser vasio!")
	private String nome;

//	@NotNull(message = "Campo NASCIMENTO não pode ser vasio!")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "nascimento")
	private LocalDate nascimento;

	/*
	 * @NotBlank(message = "Campo SEXO não pode ser vasio!") private String sexo;
	 * 
	 * @CPF
	 * 
	 * @NotBlank(message = "Campo CPF não pode ser vasio!") private String cpf;
	 * 
	 * @NotBlank(message = "Campo RG não pode ser vasio!")
	 * 
	 * @Length(max = 12, message = "O RG não pode ser maior que {max} caracteres!")
	 * 
	 * @Column(name = "rg", length = 12, nullable = false) private String rg;
	 * 
	 * @NotBlank(message = "Campo RESPONSÁVEL não pode ser vasio!") private String
	 * responsavel;
	 * 
	 * @NotBlank(message = "Campo TELEFONE não pode ser vasio!") private String
	 * telefone;
	 * 
	 * @NotBlank(message = "Campo ENDEREÇO não pode ser vasio!") private String
	 * endereco;
	 * 
	 * @NotBlank(message = "Campo ZONA não pode ser vasio!") private String zona;
	 */

	@NotNull(message = "Campo Turma não pode ser vasio!")
	private Integer turma;

	private String salaTurma;

	public AlunoDTO() {
		super();

	}

	public AlunoDTO(Aluno obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		/*
		 * this.nascimento = obj.getNascimento(); this.sexo = obj.getSexo(); this.cpf =
		 * obj.getCpf(); this.rg = obj.getRg(); this.responsavel = obj.getResponsavel();
		 * this.telefone = obj.getTelefone(); this.endereco = obj.getEndereco();
		 * this.zona = obj.getZona();
		 */
		this.turma = obj.getTurma().getId();
		this.salaTurma = obj.getTurma().getSerieNivelSubnivel().getDescricao();
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
	 * public String getResponsavel() { return responsavel; }
	 * 
	 * public void setResponsavel(String responsavel) { this.responsavel =
	 * responsavel; }
	 * 
	 * public String getTelefone() { return telefone; }
	 * 
	 * public void setTelefone(String telefone) { this.telefone = telefone; }
	 * 
	 * public String getEndereco() { return endereco; }
	 * 
	 * public void setEndereco(String endereco) { this.endereco = endereco; }
	 * 
	 * public LocalDate getNascimento() { return nascimento; }
	 * 
	 * public void setNascimento(LocalDate nascimento) { this.nascimento =
	 * nascimento; }
	 * 
	 * 
	 * public String getZona() { return zona; }
	 * 
	 * public void setZona(String zona) { this.zona = zona; }
	 */

	public Integer getTurma() {
		return turma;
	}

	public void setTurma(Integer turma) {
		this.turma = turma;
	}

	public String getSalaTurma() {
		return salaTurma;
	}

	public void setSalaTurma(String salaTurma) {
		this.salaTurma = salaTurma;
	}

}
