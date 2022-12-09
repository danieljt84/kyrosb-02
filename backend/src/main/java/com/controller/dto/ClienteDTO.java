package com.controller.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.model.ClientePessoaFisica;
import com.model.ClientePessoaJuridica;

public class ClienteDTO {

	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String endereco;
	@JsonInclude(Include.NON_NULL)
	private Long cpf;
	@JsonInclude(Include.NON_NULL)
	private Long cnpj;

	public ClienteDTO() {

	}

	public ClienteDTO(ClientePessoaFisica cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.endereco = cliente.getEndereco();
		this.dataNascimento = cliente.getDataNascimento();
	}

	public ClienteDTO(ClientePessoaJuridica cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCnpj();
		this.endereco = cliente.getEndereco();
		this.dataNascimento = cliente.getDataNascimento();
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

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
}
