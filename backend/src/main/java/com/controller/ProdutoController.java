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
import com.controller.dto.ProdutoDTO;
import com.controller.form.ProdutoForm;
import com.model.Produto;
import com.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@RequestMapping(value="/criar", method = RequestMethod.POST)
	public ResponseEntity criar(@RequestBody ProdutoForm form) {
		try {
			Produto produto = new Produto();
			BeanUtils.copyProperties(form, produto);
			produtoService.criar(produto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@RequestMapping(value="/alterar", method = RequestMethod.PUT)
	public ResponseEntity alterar(@RequestBody ProdutoForm form) {
		try {
			Produto produto = new Produto();
			BeanUtils.copyProperties(form, produto);
			produtoService.alterar(produto);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity buscarPorId(@PathVariable Long id) {
		try {
			ProdutoDTO dto = new ProdutoDTO();
			BeanUtils.copyProperties(produtoService.buscarPorId(id), dto);
			return ResponseEntity.ok().body(dto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity excluir(@PathVariable Long id) throws Exception {
		produtoService.excluir(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ResponseEntity listar() {
		List<ProdutoDTO> dtos = new ArrayList<>();
		for(Produto produto : produtoService.listar()) {
			ProdutoDTO dto = new ProdutoDTO();
			BeanUtils.copyProperties(produto, dto);
			dtos.add(dto);
		}
		return ResponseEntity.ok().body(dtos);
	}

}
