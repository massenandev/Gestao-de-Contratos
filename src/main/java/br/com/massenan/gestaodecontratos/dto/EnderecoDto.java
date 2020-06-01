package br.com.massenan.gestaodecontratos.dto;

import java.util.List;

import br.com.massenan.gestaodecontratos.domain.Endereco;
import br.com.massenan.gestaodecontratos.domain.Pessoa;

public class EnderecoDto {

	private Long id;
	private String logradouro;
	private String bairro;
	private String numero;
	private String cep;
	private String complemento;

	public static List<EnderecoDto> parse(List<Endereco>enderecos){
		return null;
	}
	
	public static Endereco parse(EnderecoDto enderecoDto) {
		Endereco ende = new Endereco();
		ende.setBairro(enderecoDto.getBairro());
		ende.setCep(enderecoDto.getCep());
		ende.setComplemento(enderecoDto.getComplemento());
		ende.setLogradouro(enderecoDto.getLogradouro());
		ende.setNumero(enderecoDto.getNumero());
		return ende;
	}

	public static EnderecoDto parse(Endereco endereco) {
		EnderecoDto dto = new EnderecoDto();
		dto.setBairro(endereco.getBairro());
		dto.setCep(endereco.getCep());
		dto.setComplemento(endereco.getComplemento());
		dto.setLogradouro(endereco.getLogradouro());
		dto.setNumero(endereco.getNumero());
		return dto;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
