package br.com.massenan.gestaodecontratos.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.massenan.gestaodecontratos.domain.ContratoModelo;
import br.com.massenan.gestaodecontratos.domain.Pessoa;
import br.com.massenan.gestaodecontratos.repository.ContratoModeloRepository;

@Component
public class ContratosModeloFantasia {
	
	@Autowired
	ContratoModeloRepository repository;
	
	public void inserirContModel() {
		List<ContratoModelo> contratos = new ArrayList<ContratoModelo>();
		
		ContratoModelo cons1 = new ContratoModelo();
		cons1.setDescricao("Descricao 1");
		cons1.setDtCadastro(LocalDateTime.now());
		cons1.setDtUltAlt(LocalDateTime.now());
//		cons1.setTipo("Contrato Imobiliário");
		
		Pessoa pess1 = new Pessoa();
		pess1.setId(1l);
		cons1.setPessoa(pess1);
		
		ContratoModelo cons2 = new ContratoModelo();
		cons2.setDescricao("Descricao 2");
		cons2.setDtCadastro(LocalDateTime.now());
		cons2.setDtUltAlt(LocalDateTime.now());
//		cons2.setTipo("Contrato Imobiliário");
		
		Pessoa pess2 = new Pessoa();
		pess2.setId(2l);
		cons2.setPessoa(pess2);
		
		ContratoModelo cons3 = new ContratoModelo();
		cons3.setDescricao("Descricao 3");
		cons3.setDtCadastro(LocalDateTime.now());
		cons3.setDtUltAlt(LocalDateTime.now());
//		cons3.setTipo("Contrato Imobiliário");
		
		Pessoa pess3 = new Pessoa();
		pess3.setId(3l);
		cons3.setPessoa(pess3);
		
		ContratoModelo cons4 = new ContratoModelo();
		cons4.setDescricao("Descricao 4");
		cons4.setDtCadastro(LocalDateTime.now());
		cons4.setDtUltAlt(LocalDateTime.now());
//		cons4.setTipo("Contrato Imobiliário");
		
		Pessoa pess4 = new Pessoa();
		pess4.setId(4l);
		cons4.setPessoa(pess4);
		
		contratos.add(cons1);
		contratos.add(cons2);
		contratos.add(cons3);
		contratos.add(cons4);

		for (ContratoModelo cons : contratos) {
			ContratoModelo consCriados = repository.save(cons);
			System.out.println(consCriados.getId());
		}
	}

}
