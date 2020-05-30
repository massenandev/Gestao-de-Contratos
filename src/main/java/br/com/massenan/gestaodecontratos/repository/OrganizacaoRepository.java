package br.com.massenan.gestaodecontratos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.massenan.gestaodecontratos.domain.Organizacao;

public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long> {

}
