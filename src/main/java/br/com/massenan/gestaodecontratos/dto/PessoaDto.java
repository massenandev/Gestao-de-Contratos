package br.com.massenan.gestaodecontratos.dto;

import br.com.massenan.gestaodecontratos.domain.Endereco;
import br.com.massenan.gestaodecontratos.domain.Pessoa;

public class PessoaDto {

	private Long id;
	private String nome;
	private String idade;
	private String cpf;
	private Endereco endereco;

	public static Pessoa parse(PessoaDto pessoaDto) {
		Pessoa pes = new Pessoa();
		pes.setCpf(pessoaDto.getCpf());
		pes.setIdade(pessoaDto.getIdade());
		pes.setNome(pessoaDto.getNome());
		
		Endereco ende = new Endereco();
		ende.setId(pessoaDto.getId());
		pes.setEndereco(ende);
		return pes;
	}

	public static PessoaDto parse(Pessoa pessoa) {
		PessoaDto dto = new PessoaDto();
		dto.setCpf(pessoa.getCpf());
		dto.setIdade(pessoa.getIdade());
		dto.setNome(pessoa.getNome());
		
		Endereco ende = new Endereco();
		ende.setId(pessoa.getId());
		dto.setEndereco(ende);
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
