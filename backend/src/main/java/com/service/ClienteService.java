package com.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.exception.CPFException;
import com.model.Cliente;
import com.model.ClientePessoaFisica;
import com.model.ClientePessoaJuridica;
import com.repository.ClientePessoaFisicaRepository;
import com.repository.ClientePessoaJuridicaRepository;
import com.repository.ClienteRepository;
@Service
public class ClienteService {
	
	@Autowired
	ClientePessoaFisicaRepository clientePessoaFisicaRepository;
	@Autowired
	ClientePessoaJuridicaRepository clientePessoaJuridicaRepository;
	@Autowired
	ClienteRepository<Cliente> clienteRepository;

	public Cliente criar(Cliente obj) {
		return clienteRepository.save(obj);
	}

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public Cliente buscarPorId(Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EntityNotFoundException("CLIENTE COM ID:" + id + " - NÃO ENCONTRADO");
		}
	}
	
	public void excluir(Long id) throws Exception {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if(optional.isPresent()) {
			try {
				clienteRepository.delete(optional.get());
			} catch (Exception e) {
				throw new Exception("PRODUTO -"+id+"- VINCULADO A OUTRA TABELA");
			}
		}else {
			throw new EntityNotFoundException("CLIENTE COM ID:" + id + " - NÃO ENCONTRADO");
		}
	}
	
	public ClientePessoaFisica alterar(ClientePessoaFisica clientePessoaFisica) throws CPFException {
		ClientePessoaFisica reference = clientePessoaFisicaRepository.getOne(clientePessoaFisica.getId());
		if(reference==null) throw new EntityNotFoundException();
		reference.setCpf(clientePessoaFisica.getCpf());
		reference.setDataNascimento(clientePessoaFisica.getDataNascimento());
		reference.setEndereco(clientePessoaFisica.getEndereco());
		reference.setNome(clientePessoaFisica.getNome());
	    return clientePessoaFisicaRepository.save(reference);
	}
	
	public ClientePessoaJuridica alterar(ClientePessoaJuridica clientePessoaJuridica) throws Exception {
		ClientePessoaJuridica reference = clientePessoaJuridicaRepository.getOne(clientePessoaJuridica.getId());
		if(reference==null) throw new EntityNotFoundException();
		reference.setCnpj(clientePessoaJuridica.getCnpj());
		reference.setDataNascimento(clientePessoaJuridica.getDataNascimento());
		reference.setEndereco(clientePessoaJuridica.getEndereco());
		reference.setNome(clientePessoaJuridica.getNome());
	    return clientePessoaJuridicaRepository.save(reference);
	}

}
