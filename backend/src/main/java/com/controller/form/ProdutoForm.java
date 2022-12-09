package com.controller.form;

import java.math.BigDecimal;

import com.util.model.Status;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
public class ProdutoForm {
	
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String descricao;
	@NotNull
	private Status status;
	@NotNull@Digits(fraction = 2, integer = 10000000)
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
