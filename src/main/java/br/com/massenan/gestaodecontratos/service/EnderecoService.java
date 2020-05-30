package br.com.massenan.gestaodecontratos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.massenan.gestaodecontratos.domain.Endereco;
import br.com.massenan.gestaodecontratos.repository.EnderecoRepository;

public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		return repository.findAll();
	}

	public void create(Endereco endereco) {
		repository.save(endereco);
	}
	
	public Endereco findById(Long id, boolean active) {
		return repository.findById(id, active);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void update(Endereco endereco) {
		repository.saveAndFlush(endereco);
	}
	
}
