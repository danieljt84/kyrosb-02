package com.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.exception.CNPJException;

import br.com.caelum.stella.validation.CNPJValidator;

@Entity
@DiscriminatorValue(value = "JURIDICA")
public class ClientePessoaJuridica extends Cliente{
	
	@Column(unique = true)
	private Long cnpj;
	
	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) throws Exception {
		CNPJValidator cnpjValidator = new CNPJValidator();
		try {
			cnpjValidator.assertValid(cnpj.toString());
		}catch (Exception e) {
			throw new CNPJException();
		}
		this.cnpj = cnpj;
	}
}
