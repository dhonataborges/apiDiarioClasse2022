package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;

import com.borges.diario_eletronico.domain.SerieNivelSubnivel;

public class SerieNivelSubnivelDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer nivel;
	private Integer subnivel;
	private String descricao;
		
	public SerieNivelSubnivelDTO() {
		super();
	}
	
	public SerieNivelSubnivelDTO(SerieNivelSubnivel obj) {
		super();
		this.id = obj.getId();
		this.nivel = obj.getNivel();
		this.subnivel = obj.getSubnivel();
		this.descricao = obj.getDescricao();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public Integer getSubnivel() {
		return subnivel;
	}
	public void setSubnivel(Integer subnivel) {
		this.subnivel = subnivel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
