package com.borges.diario_eletronico.domain.dtos;

import com.borges.diario_eletronico.domain.AlunoAula;

public class AlunoAulaDTO {
	
	private Integer id;
    private Boolean frequencia;
    private Integer aula;
    private String conteudoAula;
    private Integer aluno;
    private String nomeAluno;
    
    
	public AlunoAulaDTO() {
		super();
	}
	
	public AlunoAulaDTO(AlunoAula obj) {
		super();
		this.id = obj.getId();
		this.frequencia = obj.getFrequencia();
		this.aula = obj.getAula().getId();
		this.conteudoAula = obj.getAula().getConteudo();
		this.aluno = obj.getAluno().getId();
		this.nomeAluno = obj.getAluno().getNome();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Boolean frequencia) {
		this.frequencia = frequencia;
	}
	public Integer getAula() {
		return aula;
	}
	public void setAula(Integer aula) {
		this.aula = aula;
	}
	public String getConteudoAula() {
		return conteudoAula;
	}
	public void setConteudoAula(String conteudoAula) {
		this.conteudoAula = conteudoAula;
	}
	public Integer getAluno() {
		return aluno;
	}
	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
    
}
