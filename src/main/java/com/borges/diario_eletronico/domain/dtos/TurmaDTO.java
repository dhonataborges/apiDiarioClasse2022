package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;

import com.borges.diario_eletronico.domain.Turma;

public class TurmaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer anoLetivo;
	private Integer sala;
	private Integer serieNivelSubnivel;
	private String nomeSerieNivelSubnivel;
	
	public TurmaDTO() {
		super();
	}
	
	public TurmaDTO(Turma obj) {
		super();
		this.id = obj.getId();
		this.anoLetivo = obj.getAnoLetivo();
		this.sala = obj.getSala();
		this.serieNivelSubnivel = obj.getSerieNivelSubnivel().getNivel();
		this.nomeSerieNivelSubnivel = obj.getSerieNivelSubnivel().getDescricao();
		
		
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
