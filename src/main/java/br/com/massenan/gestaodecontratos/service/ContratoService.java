package br.com.massenan.gestaodecontratos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.massenan.gestaodecontratos.domain.Contrato;
import br.com.massenan.gestaodecontratos.repository.ContratoRepository;

@Service
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
	
	public Optional<Contrato> findById(Long id) {
		return repository.findById(id);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void update(Contrato contrato) {
		repository.saveAndFlush(contrato);
	}
}
