package br.com.massenan.gestaodecontratos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.massenan.gestaodecontratos.domain.Pessoa;
import br.com.massenan.gestaodecontratos.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}

	public void create(Pessoa pessoa) {
		repository.save(pessoa);
	}
	
	public Pessoa findById(Long id, boolean active) {
		return repository.findById(id, active);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void update(Pessoa pessoa) {
		repository.saveAndFlush(pessoa);
	}
}
