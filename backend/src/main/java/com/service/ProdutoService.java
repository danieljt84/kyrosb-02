package com.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Produto;
import com.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto criar(Produto obj) {
		return produtoRepository.save(obj);
	}

	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	
	public Produto alterar(Produto obj){
		Produto reference = produtoRepository.getOne(obj.getId());
		if(reference==null) throw new EntityNotFoundException();
		reference.setDescricao(obj.getDescricao());
		reference.setNome(obj.getNome());
		reference.setStatus(obj.getStatus());
		reference.setValorUnidade(obj.getValorUnidade());
		return produtoRepository.save(reference);
	}
	
	public Produto buscarPorId(Long id) {
		var optional = produtoRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EntityNotFoundException("PRODUTO COM ID:" + id + " - NÃO ENCONTRADO");
		}
	}
	
	public void excluir(Long id) throws Exception {
		Optional<Produto> optional = produtoRepository.findById(id);
		if(optional.isPresent()) {
			try {
				produtoRepository.delete(optional.get());
			} catch (Exception e) {
				throw new Exception("PRODUTO -"+id+"- VINCULADO A OUTRA TABELA");
			}
		}else {
			throw new EntityNotFoundException("PRODUTO COM ID:" + id + " - NÃO ENCONTRADO");
		}
	}
	

	
}
