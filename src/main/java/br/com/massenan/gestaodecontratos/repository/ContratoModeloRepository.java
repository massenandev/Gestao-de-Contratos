package br.com.massenan.gestaodecontratos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.massenan.gestaodecontratos.domain.ContratoModelo;

public interface ContratoModeloRepository extends JpaRepository<ContratoModelo, Long> {

}
