package br.com.massenan.gestaodecontratos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.massenan.gestaodecontratos.domain.Organizacao;
import br.com.massenan.gestaodecontratos.domain.Pessoa;

public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long> {

	Pessoa findById(Long id, boolean active);

}
