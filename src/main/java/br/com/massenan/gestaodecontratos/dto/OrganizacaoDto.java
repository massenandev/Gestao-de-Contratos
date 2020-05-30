package br.com.massenan.gestaodecontratos.dto;

import java.util.List;

import br.com.massenan.gestaodecontratos.domain.Endereco;
import br.com.massenan.gestaodecontratos.domain.Organizacao;

public class OrganizacaoDto {

	private Long id;
	private String nomeFantasia;
	private String nomeRegistro;
	private String cnpj;
	private Endereco endereco;
	private boolean ativo;

	public static List<OrganizacaoDto> parse(List<Organizacao> organizacoes) {
		return null;
	}

	public static Organizacao parse(OrganizacaoDto organizacaoDto) {
		Organizacao org = new Organizacao();
		org.setId(organizacaoDto.getId());
		org.setNomeFantasia(organizacaoDto.getNomeFantasia());
		org.setNomeRegistro(organizacaoDto.getNomeRegistro());
		org.setCnpj(organizacaoDto.getCnpj());
		org.setAtivo(organizacaoDto.isAtivo());

		Endereco ende = new Endereco();
		ende.setId(organizacaoDto.getId());
		org.setEndereco(ende);
		return org;
	}

	public static OrganizacaoDto parse(Organizacao organizacao) {
		OrganizacaoDto dto = new OrganizacaoDto();
		dto.setId(organizacao.getId());
		dto.setNomeFantasia(organizacao.getNomeFantasia());
		dto.setNomeRegistro(organizacao.getNomeRegistro());
		dto.setCnpj(organizacao.getCnpj());
		dto.setAtivo(organizacao.isAtivo());

		Endereco ende = new Endereco();
		ende.setId(organizacao.getId());
		dto.setEndereco(ende);
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeRegistro() {
		return nomeRegistro;
	}

	public void setNomeRegistro(String nomeRegistro) {
		this.nomeRegistro = nomeRegistro;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
