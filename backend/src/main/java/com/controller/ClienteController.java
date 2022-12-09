package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.controller.dto.ClienteDTO;
import com.controller.form.ClienteForm;
import com.exception.CNPJJUNTOCOMCPFException;
import com.model.Cliente;
import com.model.ClientePessoaFisica;
import com.model.ClientePessoaJuridica;
import com.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@RequestMapping(value="/criar",method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public ResponseEntity criar(@Valid @RequestBody ClienteForm clienteForm) throws CNPJJUNTOCOMCPFException {
		clienteForm.validaCpfECnpj();
		if (clienteForm.getCpf()!=null) {
			ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
			BeanUtils.copyProperties(clienteForm, clientePessoaFisica);
			clienteService.criar(clientePessoaFisica);
		} else {
			ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica();
			BeanUtils.copyProperties(clienteForm, clientePessoaJuridica);
			clienteService.criar(clientePessoaJuridica);
		}
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value="/alterar",method = RequestMethod.PUT)
	public ResponseEntity alterar(@RequestBody ClienteForm clienteForm) throws Exception {
		clienteForm.validaCpfECnpj();
		if (clienteForm.getCpf()!=null) {
			ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
			BeanUtils.copyProperties(clienteForm, clientePessoaFisica);
			clienteService.alterar(clientePessoaFisica);
		} else {
			ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica();
			BeanUtils.copyProperties(clienteForm, clientePessoaJuridica);
			clienteService.alterar(clientePessoaJuridica);
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity buscarPorId(@PathVariable Long id) {

		ClienteDTO clienteDTO = new ClienteDTO();
		BeanUtils.copyProperties(clienteService.buscarPorId(id), clienteDTO);
		return ResponseEntity.ok().body(clienteDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity excluir(@PathVariable Long id) throws Exception {
		clienteService.excluir(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	

	@RequestMapping(value="/listar",method = RequestMethod.GET)
	public ResponseEntity listar() {
		List<ClienteDTO> dtos = new ArrayList<>();
		for (Cliente cliente : clienteService.listar()) {
			ClienteDTO clienteDTO = new ClienteDTO();
			BeanUtils.copyProperties(cliente, clienteDTO);
			dtos.add(clienteDTO);
		}
		return ResponseEntity.ok().body(dtos);
	}
	
}
