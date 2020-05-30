package br.com.massenan.gestaodecontratos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.massenan.gestaodecontratos.domain.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

	@Query("SELECT c FROM Contrato c WHERE c.id = ?1 AND c.ativo = ?2")
	Contrato findById(Long id, boolean active);

}
