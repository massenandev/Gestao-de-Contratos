package br.com.massenan.gestaodecontratos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.massenan.gestaodecontratos.domain.Cidade;
import br.com.massenan.gestaodecontratos.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	/**
	 * 
	 * @return
	 */
	public List<Cidade> findAll(){
		return repository.findAll();
	}
	
	public void create(Cidade cidade) {
		repository.save(cidade);
	}
	
	public Optional<Cidade> findById(Long id) {
		return repository.findById(id);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void update(Cidade cidade) {
		repository.saveAndFlush(cidade);
	}
}
