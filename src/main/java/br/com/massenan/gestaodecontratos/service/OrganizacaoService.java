package br.com.massenan.gestaodecontratos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.massenan.gestaodecontratos.domain.Organizacao;
import br.com.massenan.gestaodecontratos.domain.Pessoa;
import br.com.massenan.gestaodecontratos.repository.OrganizacaoRepository;

public class OrganizacaoService {

	@Autowired
	private OrganizacaoRepository repository;
	
	public List<Organizacao> findAll(){
		return repository.findAll();
	}

	public void create(Organizacao organizacao) {
		repository.save(organizacao);
	}
	
	public Organizacao findById(Long id, boolean active) {
		return repository.findById(id, active);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void update(Organizacao organizacao) {
		repository.saveAndFlush(organizacao);
	}
}
