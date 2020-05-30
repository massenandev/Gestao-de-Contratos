package br.com.massenan.gestaodecontratos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.massenan.gestaodecontratos.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	@Query("SELECT e FROM Endereco e WHERE e.id = ?1 AND e.ativo = ?2")
	Endereco findById(Long id, boolean active);

}
