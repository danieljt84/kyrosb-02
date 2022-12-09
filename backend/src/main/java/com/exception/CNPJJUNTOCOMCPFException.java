package com.exception;

public class CNPJJUNTOCOMCPFException extends Exception {

	public CNPJJUNTOCOMCPFException() {
		super("FORMULARIO NÃO PODE CONTER CNPJ E CPJ JUNTAMENTE");
	}
}
