package br.com.massenan.gestaodecontratos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.massenan.gestaodecontratos.domain.ContratoModelo;
import br.com.massenan.gestaodecontratos.repository.ContratoModeloRepository;

public class ContratoModeloService {
	
	@Autowired
	private ContratoModeloRepository repository;
	
	public List<ContratoModelo> findAll(){
		return repository.findAll();
	}

	public void create(ContratoModelo contratoModelo) {
		repository.save(contratoModelo);
	}
	
	public ContratoModelo findById(Long id, boolean active) {
		return repository.findById(id, active);
	}
	
	public void deleteById(Long id) {
		ContratoModelo cont = new ContratoModelo();
		cont.setId(id);
		repository.delete(cont);
	}
	
	public void update(ContratoModelo contratoModelo) {
		repository.saveAndFlush(contratoModelo);
	}

}
