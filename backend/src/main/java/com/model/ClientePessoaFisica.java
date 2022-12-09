package com.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.exception.CPFException;

import br.com.caelum.stella.validation.CPFValidator;

@Entity
@DiscriminatorValue(value = "FISICA")
public class ClientePessoaFisica extends Cliente {

	@Column(unique = true)
	private Long cpf;
	
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) throws CPFException  {
		CPFValidator cpfValidator = new CPFValidator();
		try {
			cpfValidator.assertValid(cpf.toString());
		} catch (Exception e) {
			throw new CPFException();
		}
		this.cpf = cpf;
	}

}
