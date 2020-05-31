package br.com.massenan.gestaodecontratos.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.massenan.gestaodecontratos.domain.Contrato;
import br.com.massenan.gestaodecontratos.domain.Pessoa;
import br.com.massenan.gestaodecontratos.repository.ContratoRepository;

@Component
public class ContratosFantasia {

	@Autowired
	ContratoRepository repository;

	public void inserirContratos() {
		List<Contrato> contratos = new ArrayList<Contrato>();
		
		Contrato con1 = new Contrato();
		con1.setAtivo(true);
		con1.setDataExpiracao(LocalDateTime.now());
		con1.setDataRevogacao(LocalDateTime.now());
		con1.setDataVigor(LocalDateTime.now());
		con1.setDescricao("Descricao 1");
		con1.setDtCadastro(LocalDateTime.now());
		con1.setDtUltAlt(LocalDateTime.now());
		con1.setTipo("Contrato Imobiliário");

		Pessoa pess1 = new Pessoa();
		pess1.setId(1l);
		con1.setPessoa(pess1);
		
		Contrato con2 = new Contrato();
		con2.setAtivo(true);
		con2.setDataExpiracao(LocalDateTime.now());
		con2.setDataRevogacao(LocalDateTime.now());
		con2.setDataVigor(LocalDateTime.now());
		con2.setDescricao("Descricao 2");
		con2.setDtCadastro(LocalDateTime.now());
		con2.setDtUltAlt(LocalDateTime.now());
		con2.setTipo("Contrato Imobiliário");

		Pessoa pess2 = new Pessoa();
		pess2.setId(2l);
		con2.setPessoa(pess2);
		
		Contrato con3 = new Contrato();
		con3.setAtivo(true);
		con3.setDataExpiracao(LocalDateTime.now());
		con3.setDataRevogacao(LocalDateTime.now());
		con3.setDataVigor(LocalDateTime.now());
		con3.setDescricao("Descricao 2");
		con3.setDtCadastro(LocalDateTime.now());
		con3.setDtUltAlt(LocalDateTime.now());
		con3.setTipo("Contrato Imobiliário");

		Pessoa pess3 = new Pessoa();
		pess3.setId(3l);
		con3.setPessoa(pess3);
		
		Contrato con4 = new Contrato();
		con4.setAtivo(true);
		con4.setDataExpiracao(LocalDateTime.now());
		con4.setDataRevogacao(LocalDateTime.now());
		con4.setDataVigor(LocalDateTime.now());
		con4.setDescricao("Descricao 2");
		con4.setDtCadastro(LocalDateTime.now());
		con4.setDtUltAlt(LocalDateTime.now());
		con4.setTipo("Contrato Imobiliário");

		Pessoa pess4 = new Pessoa();
		pess4.setId(4l);
		con4.setPessoa(pess4);
		
		contratos.add(con1);
		contratos.add(con2);
		contratos.add(con3);
		contratos.add(con4);
		
		for (Contrato con : contratos) {
			Contrato contCriado = repository.save(con);
			System.out.println(contCriado.getId());
		}
		
	}
}
