package br.com.massenan.gestaodecontratos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.massenan.gestaodecontratos.domain.PerfilEnum;
import br.com.massenan.gestaodecontratos.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT u FROM Usuario u WHERE u.id = ?1 AND u.ativo = ?2")
	Usuario findById(Long id, boolean active);

	@Transactional
	@Modifying
	@Query("UPDATE Usuario u SET u.ativo = ?1 WHERE u.id = ?2")
	public void updateStatus( boolean active, Long id);

	@Transactional
	@Modifying
	@Query("UPDATE Usuario u SET u.perfil = ?1 WHERE u.id = ?2")
	public void updatePerfil(PerfilEnum perfil, Long id);

}
