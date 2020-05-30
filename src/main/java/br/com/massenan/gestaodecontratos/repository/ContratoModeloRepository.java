package br.com.massenan.gestaodecontratos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.massenan.gestaodecontratos.domain.ContratoModelo;

public interface ContratoModeloRepository extends JpaRepository<ContratoModelo, Long> {

	@Query("SELECT c FROM ContratoModelo c WHERE c.id = ?1 AND c.ativo = ?2")
	ContratoModelo findById(Long id, boolean active);

}
