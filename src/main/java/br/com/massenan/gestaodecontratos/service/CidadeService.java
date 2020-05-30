package br.com.massenan.gestaodecontratos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.massenan.gestaodecontratos.domain.Cidade;
import br.com.massenan.gestaodecontratos.repository.CidadeRepository;

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
	
	/**
	 * 
	 * @param user
	 */
	public void create(Cidade cidade) {
		repository.save(cidade);
	}
	
	public Cidade findById(Long id, boolean active) {
		return repository.findById(id, active);
	}
	
	public void deleteById(Long id) {
		Cidade cid = new Cidade();
		cid.setId(id);
		repository.delete(cid);
	}
	
	public void update(Cidade cidade) {
		repository.saveAndFlush(cidade);
	}
}
