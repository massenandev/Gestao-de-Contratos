package br.com.massenan.gestaodecontratos.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.massenan.gestaodecontratos.domain.Cidade;
import br.com.massenan.gestaodecontratos.repository.CidadeRepository;

@Component
public class CidadesFantasia {

	@Autowired
	private CidadeRepository repository;
	
	public void inserirCidades() {
		List<Cidade> cidades = new ArrayList<Cidade>();
		
		Cidade cid1 = new Cidade();
		cid1.setNome("Natal");
		cid1.setUf("RN");
		
		Cidade cid2 = new Cidade();
		cid2.setNome("São Paulo");
		cid2.setUf("SP");
		
		Cidade cid3 = new Cidade();
		cid3.setNome("Rio de Janeiro");
		cid3.setUf("RJ");
		
		Cidade cid4 = new Cidade();
		cid4.setNome("Natuba");
		cid4.setUf("PB");
		
		cidades.add(cid1);
		cidades.add(cid2);
		cidades.add(cid3);
		cidades.add(cid4);
		
		for (Cidade cid : cidades) {
			Cidade cidCriada = repository.save(cid);
			System.out.println(cidCriada.getId());
		}
	}
}
