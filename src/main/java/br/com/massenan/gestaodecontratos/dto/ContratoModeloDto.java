package br.com.massenan.gestaodecontratos.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.massenan.gestaodecontratos.domain.ContratoModelo;
import br.com.massenan.gestaodecontratos.domain.Pessoa;

public class ContratoModeloDto {

	private Long id;
	private String tipo;
	private String descricao;
	private LocalDateTime dtCadastro;
	private LocalDateTime dtUltAlt;
	private Pessoa pessoa;

	public static List<ContratoModeloDto> parse(List<ContratoModelo> modelos) {
		return null;
	}

	public static ContratoModelo parse(ContratoModeloDto contratoModeloDto) {
		ContratoModelo mod = new ContratoModelo();
		mod.setId(contratoModeloDto.getId());
		mod.setTipo(contratoModeloDto.getTipo());
		mod.setDescricao(contratoModeloDto.getDescricao());
		mod.setDtCadastro(contratoModeloDto.getDtCadastro());
		mod.setDtUltAlt(contratoModeloDto.getDtUltAlt());

		Pessoa pess = new Pessoa();
		pess.setId(contratoModeloDto.getId());
		mod.setPessoa(pess);
		return mod;
	}

	public static ContratoModeloDto parse(ContratoModelo contratoModelo) {
		ContratoModeloDto dto = new ContratoModeloDto();
		dto.setId(contratoModelo.getId());
		dto.setTipo(contratoModelo.getTipo());
		dto.setDescricao(contratoModelo.getDescricao());
		dto.setDtCadastro(contratoModelo.getDtCadastro());
		dto.setDtUltAlt(contratoModelo.getDtUltAlt());

		Pessoa pess = new Pessoa();
		pess.setId(contratoModelo.getId());
		dto.setPessoa(pess);
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public LocalDateTime getDtUltAlt() {
		return dtUltAlt;
	}

	public void setDtUltAlt(LocalDateTime dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
