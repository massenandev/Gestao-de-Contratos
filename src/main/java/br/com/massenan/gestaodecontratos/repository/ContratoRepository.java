package br.com.massenan.gestaodecontratos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.massenan.gestaodecontratos.domain.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

	Contrato findById(Long id, boolean active);

}
