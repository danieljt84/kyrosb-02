package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.controller.dto.LancamentoDTO;
import com.controller.form.LancamentoForm;
import com.model.Cliente;
import com.model.Lancamento;
import com.model.Produto;
import com.service.ClienteService;
import com.service.LancamentoService;
import com.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {
	
	@Autowired
	LancamentoService lancamentoService;
	@Autowired
	ClienteService clienteService;
	@Autowired
	ProdutoService produtoService;
	
	@RequestMapping(value="/criar",method = RequestMethod.POST)
	public ResponseEntity criar(@Valid@RequestBody LancamentoForm form) {
		try {
			Lancamento lancamento = new Lancamento();
			Cliente cliente = clienteService.buscarPorId(form.getClienteId());
			Produto produto = produtoService.buscarPorId(form.getProdutoId());
			BeanUtils.copyProperties(form, lancamento);
			lancamento.setCliente(cliente);
			lancamento.setProduto(produto);
			lancamentoService.criar(lancamento);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@RequestMapping(value = "/alterar", method = RequestMethod.PUT)
	public ResponseEntity alterar(@RequestBody LancamentoForm form) {
		try {
			Lancamento lancamento = new Lancamento();
			Cliente cliente = clienteService.buscarPorId(form.getClienteId());
			Produto produto = produtoService.buscarPorId(form.getProdutoId());
			BeanUtils.copyProperties(form, lancamento);
			lancamento.setCliente(cliente);
			lancamento.setProduto(produto);
			lancamentoService.alterar(lancamento);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
		    e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity buscarPorId(@PathVariable Long id) {
		try {
			LancamentoDTO dto = new LancamentoDTO();
			Lancamento lancamento = lancamentoService.buscarPorId(id);
			BeanUtils.copyProperties(lancamento,dto);
			dto.setClienteId(lancamento.getCliente().getId());
			dto.setProdutoId(lancamento.getProduto().getId());
			return ResponseEntity.ok().body(dto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity excluir(@PathVariable Long id) throws Exception {
		lancamentoService.excluir(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ResponseEntity listar() {
		List<LancamentoDTO> dtos = new ArrayList<>();
		for(Lancamento lancamento : lancamentoService.listar()) {
			LancamentoDTO dto = new LancamentoDTO();
			BeanUtils.copyProperties(lancamento,dto);
			dto.setClienteId(lancamento.getCliente().getId());
			dto.setProdutoId(lancamento.getProduto().getId());
			dtos.add(dto);
		}
		return ResponseEntity.ok().body(dtos);
	}
}
