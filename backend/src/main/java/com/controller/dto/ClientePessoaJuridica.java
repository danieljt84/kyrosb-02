package com.controller.dto;

import java.time.LocalDate;

public class ClientePessoaJuridica {
	
	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String endereco;
	private Long cnpj;
	
	public ClientePessoaJuridica(ClientePessoaJuridica clientePessoaJuridica) {
		this.cnpj = clientePessoaJuridica.getCnpj();
		this.id = clientePessoaJuridica.getId();
		this.nome = clientePessoaJuridica.getNome();
		this.dataNascimento = clientePessoaJuridica.getDataNascimento();
		this.endereco = clientePessoaJuridica.getEndereco();
	}
	
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
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
