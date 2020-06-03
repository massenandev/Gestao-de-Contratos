package br.com.massenan.gestaodecontratos.dummyData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.massenan.gestaodecontratos.domain.Endereco;
import br.com.massenan.gestaodecontratos.domain.Pessoa;
import br.com.massenan.gestaodecontratos.repository.PessoaRepository;

@Component
public class PessoasFantasia {
	
	@Autowired
	PessoaRepository repository;
	
	public void inserirPessoas() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		Pessoa pess1 = new Pessoa();
		pess1.setAtivo(true);
		pess1.setNome("Fulano de Tal");
		pess1.setCelular("00000000");
		pess1.setCpf("1234567891012");
		pess1.setEmail("aaa@gmail.com");
		pess1.setDtNascimento("11/05/1987");
		pess1.setTelPrincipal("123456789");
		pess1.setTelResidencial("132456789");
//		pess1.setPerfil("Gestor");

		Pessoa pess2 = new Pessoa();
		pess2.setAtivo(true);
		pess2.setNome("Sicrano bla bla");
		pess2.setCelular("111111111");
		pess2.setCpf("1234455891012");
		pess2.setEmail("bbb@gmail.com");
		pess2.setDtNascimento("15/12/1996");
		pess2.setTelPrincipal("14725839");
		pess2.setTelResidencial("369258147");
//		pess2.setPerfil("Gestor");
		
		Pessoa pess3 = new Pessoa();
		pess3.setAtivo(true);
		pess3.setNome("Tiazinha da esquina");
		pess3.setCelular("222222222");
		pess3.setCpf("1234789652");
		pess3.setEmail("ccc@gmail.com");
		pess3.setDtNascimento("14/12/1993");
		pess3.setTelPrincipal("123456789");
		pess3.setTelResidencial("132456789");
//		pess3.setPerfil("Gestor");
		
		Pessoa pess4 = new Pessoa();
		pess4.setAtivo(true);
		pess4.setNome("Tiozao da esquina");
		pess4.setCelular("333333333");
		pess4.setCpf("79652165");
		pess4.setEmail("ddd@gmail.com");
		pess4.setDtNascimento("15/12/1995");
		pess4.setTelPrincipal("123456789");
		pess4.setTelResidencial("132456789");
//		pess4.setPerfil("Gestor");
		
		pessoas.add(pess1);
		pessoas.add(pess2);
		pessoas.add(pess3);
		pessoas.add(pess4);

		for (Pessoa pess : pessoas) {
			Pessoa pessoaCriada = repository.save(pess);
			System.out.println(pessoaCriada.getId());
		}
	}
}
