package com.controller.form;

import java.time.LocalDate;
import org.hibernate.validator.constraints.Range;
import com.exception.CNPJJUNTOCOMCPFException;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class ClienteForm {
	
	private Long id;
	@NotNull@NotBlank@Size(max = 40)
	private String nome;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull@NotBlank@Size(max = 50)
	private String endereco;
	@Digits(integer=11, fraction=0)
	private Long cpf;
	@Digits(integer=14, fraction=0)
	private Long cnpj;
	
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
	
	public void validaCpfECnpj() throws CNPJJUNTOCOMCPFException{
		if(this.cpf!=null & this.cnpj!=null) {
			throw new CNPJJUNTOCOMCPFException();
		}
		if(this.cnpj==null & this.cpf==null) {
			throw new NullPointerException("CPF OU CNPJ PRECISA SER PREECHIDO");
		}
	}
}
