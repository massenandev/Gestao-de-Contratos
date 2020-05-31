package br.com.massenan.gestaodecontratos.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.massenan.gestaodecontratos.domain.Endereco;
import br.com.massenan.gestaodecontratos.domain.Organizacao;
import br.com.massenan.gestaodecontratos.repository.OrganizacaoRepository;

@Component
public class OrganizacoesFantasia {
	
	@Autowired
	private OrganizacaoRepository repository;
	
	public void inserirOrganizacoes() {
		List<Organizacao> orgs = new ArrayList<Organizacao>();
		
		Organizacao org1 = new Organizacao();
		org1.setAtivo(true);
		org1.setCnpj("1111111112");
		org1.setNomeFantasia("Nome fantasia 1");
		org1.setNomeRegistro("Nome registro 1");
		
		Endereco end1 = new Endereco();
		end1.setId(1l);
		org1.setEndereco(end1);
		
		Organizacao org2 = new Organizacao();
		org2.setAtivo(true);
		org2.setCnpj("5555555553");
		org2.setNomeFantasia("Nome fantasia 2");
		org2.setNomeRegistro("Nome registro 2");
		
		Endereco end2 = new Endereco();
		end2.setId(2l);
		org2.setEndereco(end2);
		
		Organizacao org3 = new Organizacao();
		org3.setAtivo(true);
		org3.setCnpj("4444444445");
		org3.setNomeFantasia("Nome fantasia 3");
		org3.setNomeRegistro("Nome registro 3");
		
		Endereco end3 = new Endereco();
		end3.setId(3l);
		org3.setEndereco(end3);
		
		Organizacao org4 = new Organizacao();
		org4.setAtivo(true);
		org4.setCnpj("88877788877");
		org4.setNomeFantasia("Nome fantasia 4");
		org4.setNomeRegistro("Nome registro 4");
		
		Endereco end4 = new Endereco();
		end4.setId(4l);
		org4.setEndereco(end4);
		
		orgs.add(org1);
		orgs.add(org2);
		orgs.add(org3);
		orgs.add(org4);

		for (Organizacao org : orgs) {
			Organizacao orgCriada = repository.save(org);
			System.out.println(orgCriada.getId());
		}
	}

}
