package com.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.model.Lancamento;
import com.repository.LancamentoRepository;

@Service
public class LancamentoService{

	@Autowired
	LancamentoRepository lancamentoRepository;
	
	public Lancamento criar(Lancamento obj) {
		return lancamentoRepository.save(obj);
	}

	public List<Lancamento> listar() {
		return lancamentoRepository.findAll();
	}
	
	public Lancamento alterar(Lancamento obj) {
		Lancamento reference = lancamentoRepository.getOne(obj.getId());
		if(reference==null) throw new EntityNotFoundException();
		reference.setCliente(obj.getCliente());
		reference.setProduto(obj.getProduto());
		reference.setDataVenda(obj.getDataVenda());
		reference.setQuantidadeVendida(obj.getQuantidadeVendida());
		reference.setValorTotal(obj.getValorTotal());
		return lancamentoRepository.save(reference);
	}

	public Lancamento buscarPorId(Long id) {
		var optional = lancamentoRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EntityNotFoundException("LANÇAMENTO COM ID:" + id + " - NÃO ENCONTRADO");
		}
	}
	
	public void excluir(Long id) throws Exception {
		Optional<Lancamento> optional = lancamentoRepository.findById(id);
		if(optional.isPresent()) {
			try {
				lancamentoRepository.delete(optional.get());
			} catch (Exception e) {
				throw new Exception("LANÇAMENTO -"+id+"- VINCULADO A OUTRA TABELA");
			}
		}else {
			throw new EntityNotFoundException("LANÇAMENTO COM ID:" + id + " - NÃO ENCONTRADO");
		}
	}
	

}
