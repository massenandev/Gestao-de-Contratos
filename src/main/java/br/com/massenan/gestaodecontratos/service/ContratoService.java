package br.com.massenan.gestaodecontratos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.massenan.gestaodecontratos.domain.Contrato;
import br.com.massenan.gestaodecontratos.repository.ContratoRepository;

public class ContratoService {

	@Autowired
	private ContratoRepository repository;
	
	public List<Contrato> findAll(){
		return repository.findAll();
	}

	public void create(Contrato contrato) {
		repository.save(contrato);
	}
	
	public Contrato findById(Long id, boolean active) {
		return repository.findById(id, active);
	}
	
	public void deleteById(Long id) {
		Contrato cont = new Contrato();
		cont.setId(id);
		repository.delete(cont);
	}
	
	public void update(Contrato contrato) {
		repository.saveAndFlush(contrato);
	}
}
