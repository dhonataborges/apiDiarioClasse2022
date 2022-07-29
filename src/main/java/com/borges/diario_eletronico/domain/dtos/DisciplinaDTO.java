package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;

import com.borges.diario_eletronico.domain.Disciplina;

public class DisciplinaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private Integer id;
	private String nome;
	private String ementa;
    private Integer serieNivelSubnivel;
	private String nomeSerieNivelSubnivel;
 	
	public DisciplinaDTO() {
		super();
	}
	
	public DisciplinaDTO(Disciplina obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.ementa = obj.getEmenta();
		this.serieNivelSubnivel = obj.getSerieNivelSubnivel().getId();
		this.nomeSerieNivelSubnivel = obj.getSerieNivelSubnivel().getDescricao();
		
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

	public Integer getSerieNivelSubnivel() {
		return serieNivelSubnivel;
	}

	public void setSerieNivelSubnivel(Integer serieNivelSubnivel) {
		this.serieNivelSubnivel = serieNivelSubnivel;
	}

	public String getNomeSerieNivelSubnivel() {
		return nomeSerieNivelSubnivel;
	}

	public void setNomeSerieNivelSubnivel(String nomeSerieNivelSubnivel) {
		this.nomeSerieNivelSubnivel = nomeSerieNivelSubnivel;
	}

}
