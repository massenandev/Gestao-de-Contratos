package br.com.massenan.gestaodecontratos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.massenan.gestaodecontratos.domain.Organizacao;

public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long> {

	@Query("SELECT o FROM Organizacao o WHERE o.id = ?1 AND o.ativo = ?2")
	Organizacao findById(Long id, boolean active);

}
