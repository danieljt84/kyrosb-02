package com.controller.dto;

import java.math.BigDecimal;

import com.util.model.Status;

public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private Status status;
	private BigDecimal valorUnidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public BigDecimal getValorUnidade() {
		return valorUnidade;
	}
	public void setValorUnidade(BigDecimal valorUnidade) {
		this.valorUnidade = valorUnidade;
	}
	
	
	
}
