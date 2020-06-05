package br.com.massenan.gestaodecontratos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.massenan.gestaodecontratos.domain.PerfilEnum;
import br.com.massenan.gestaodecontratos.domain.Usuario;
import br.com.massenan.gestaodecontratos.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	
	public List<Usuario> findAll(){
		return repository.findAll();
	}

	public void create(Usuario usuario) {
		repository.save(usuario);
	}
	
	public Usuario findById(Long id, boolean active) {
		return repository.findById(id, active);
	}

	public Optional<Usuario> findById(Long id) {
		return repository.findById(id);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void update(Usuario usuario) {
		repository.saveAndFlush(usuario);
	}

	public void updateStatus(Long id, boolean status) {
		repository.updateStatus(status, id);
	}

	public void updatePerfil(Long id, PerfilEnum perfil) {
		repository.updatePerfil(perfil, id);
	}
	
	
}
