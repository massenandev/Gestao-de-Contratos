package br.com.massenan.gestaodecontratos.dto;

import java.util.List;

import br.com.massenan.gestaodecontratos.domain.Cidade;

public class CidadeDto {

	private Long id;
	private String nome;
	private String uf;
	
	public static List<CidadeDto> parse(List<Cidade> cidades) {
		return null;
	}

	public static Cidade parse(CidadeDto cidadeDto) {
		Cidade cid = new Cidade();
		cid.setId(cidadeDto.getId());
		cid.setNome(cidadeDto.getNome());
		cid.setUf(cidadeDto.getUf());
		return cid;
	}

	public static CidadeDto parse(Cidade cidade) {
		CidadeDto dto = new CidadeDto();
		dto.setId(cidade.getId());
		dto.setNome(cidade.getNome());
		dto.setUf(cidade.getUf());
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
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
