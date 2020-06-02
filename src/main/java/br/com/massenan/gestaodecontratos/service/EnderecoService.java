package br.com.massenan.gestaodecontratos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.massenan.gestaodecontratos.domain.Endereco;
import br.com.massenan.gestaodecontratos.repository.EnderecoRepository;

@Service
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
	
	public Optional<Endereco> findById(Long id) {
		return repository.findById(id);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void update(Endereco endereco) {
		repository.saveAndFlush(endereco);
	}
	
}
