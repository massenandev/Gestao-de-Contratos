package br.com.massenan.gestaodecontratos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.massenan.gestaodecontratos.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
