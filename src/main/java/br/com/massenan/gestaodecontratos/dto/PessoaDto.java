package br.com.massenan.gestaodecontratos.dto;

import java.util.List;

import br.com.massenan.gestaodecontratos.domain.Endereco;
import br.com.massenan.gestaodecontratos.domain.Pessoa;

public class PessoaDto {

	private Long id;
	private String nome;
	private String perfil;
	private String idade;
	private String cpf;
	private String telResidencial;
	private String telPrincipal;
	private String celular;
	private String email;
	private Endereco endereco;
	private boolean ativo;

	public static List<PessoaDto> parse(List<Pessoa>pessoas){
		return null;
	}
	
	public static Pessoa parse(PessoaDto pessoaDto) {
		Pessoa pes = new Pessoa();
		pes.setId(pessoaDto.getId());
		pes.setNome(pessoaDto.getNome());
		pes.setIdade(pessoaDto.getIdade());
		pes.setCpf(pessoaDto.getCpf());
		pes.setTelResidencial(pessoaDto.getTelResidencial());
		pes.setTelPrincipal(pessoaDto.getTelPrincipal());
		pes.setCelular(pessoaDto.getCelular());
		pes.setEmail(pessoaDto.getEmail());
		pes.setAtivo(pessoaDto.isAtivo());
		
		Endereco ende = new Endereco();
		ende.setId(pessoaDto.getId());
		pes.setEndereco(ende);
		return pes;
	}

	public static PessoaDto parse(Pessoa pessoa) {
		PessoaDto dto = new PessoaDto();
		dto.setId(pessoa.getId());
		dto.setNome(pessoa.getNome());
		dto.setIdade(pessoa.getIdade());
		dto.setCpf(pessoa.getCpf());
		dto.setTelResidencial(pessoa.getTelResidencial());
		dto.setTelPrincipal(pessoa.getTelPrincipal());
		dto.setCelular(pessoa.getCelular());
		dto.setEmail(pessoa.getEmail());
		dto.setEndereco(pessoa.getEndereco());
		dto.setAtivo(pessoa.isAtivo());
		
		
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

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
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

	public String getTelResidencial() {
		return telResidencial;
	}

	public void setTelResidencial(String telResidencial) {
		this.telResidencial = telResidencial;
	}

	public String getTelPrincipal() {
		return telPrincipal;
	}

	public void setTelPrincipal(String telPrincipal) {
		this.telPrincipal = telPrincipal;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
}
