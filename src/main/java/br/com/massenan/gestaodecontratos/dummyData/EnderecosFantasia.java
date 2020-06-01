package br.com.massenan.gestaodecontratos.dummyData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.massenan.gestaodecontratos.domain.Cidade;
import br.com.massenan.gestaodecontratos.domain.Endereco;
import br.com.massenan.gestaodecontratos.repository.EnderecoRepository;

@Component
public class EnderecosFantasia {
	
	@Autowired
	private EnderecoRepository repository;
	
	private void inserirEnderecos() {
		List<Endereco> ends = new ArrayList<Endereco>();
		
		Endereco end1 = new Endereco();
		end1.setAtivo(true);
		end1.setBairro("Bairro 1 ");
		end1.setCep("59010101");
		end1.setComplemento("Proximo ao ponto 1");
		end1.setLogradouro("Rua um");
		end1.setNumero("11");
		
		Cidade cid1 = new Cidade();
		cid1.setId(1l);
		end1.setCidade(cid1);
		
		Endereco end2 = new Endereco();
		end2.setAtivo(true);
		end2.setBairro("Bairro 2 ");
		end2.setCep("59020202");
		end2.setComplemento("Proximo ao ponto 2");
		end2.setLogradouro("Rua dois");
		end2.setNumero("22");
		
		Cidade cid2 = new Cidade();
		cid2.setId(2l);
		end2.setCidade(cid2);
		
		Endereco end3 = new Endereco();
		end1.setAtivo(true);
		end3.setBairro("Bairro 3 ");
		end3.setCep("59030303");
		end3.setComplemento("Proximo ao ponto 3");
		end3.setLogradouro("Rua tres");
		end3.setNumero("33");
		
		Cidade cid3 = new Cidade();
		cid3.setId(3l);
		end3.setCidade(cid3);
		
		Endereco end4 = new Endereco();
		end4.setAtivo(true);
		end4.setBairro("Bairro 4 ");
		end4.setCep("59040404");
		end4.setComplemento("Proximo ao ponto 4");
		end4.setLogradouro("Rua quatro");
		end4.setNumero("44");
		
		Cidade cid4 = new Cidade();
		cid4.setId(4l);
		end4.setCidade(cid4);
		
		ends.add(end1);
		ends.add(end2);
		ends.add(end3);
		ends.add(end4);
		
		for (Endereco end : ends) {
			Endereco endCriado = repository.save(end);
			System.out.println(endCriado.getId());
		}
	}
}
