package com.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public class LancamentoForm {
	
	private Long id;
	@NotNull
	private LocalDate dataVenda;
	@NotNull@Digits(fraction = 0, integer = 100000000)
	private Long clienteId;
	@NotNull@Digits(fraction = 0, integer = 100000000)
	private Long produtoId;
	@Digits(fraction = 2,integer = 10000000)
	private Double quantidadeVendida;
	@Digits(fraction = 2,integer = 10000000)
	private BigDecimal valorTotal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Double getQuantidadeVendida() {
		return quantidadeVendida;
	}
	public void setQuantidadeVendida(Double quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public Long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	
	
}
