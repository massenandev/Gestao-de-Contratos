package br.com.massenan.gestaodecontratos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.massenan.gestaodecontratos.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query("SELECT p FROM Pessoa p WHERE p.id = ?1 AND p.ativo = ?2")
	Pessoa findById(Long id, boolean active);

}
