package br.com.massenan.gestaodecontratos.service;

import java.util.List;
import java.util.Optional;

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
	
	/**
	 * 
	 * @param user
	 */
	public void create(Pessoa pessoa) {
		repository.save(pessoa);
	}
	
	public Optional<Pessoa> findById(Long id) {
		return repository.findById(id);
	}
	
	public void deleteById(Long id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(id);
		repository.delete(pessoa);
	}
	
	public void update(Pessoa pessoa) {
		repository.saveAndFlush(pessoa);
	}
}
