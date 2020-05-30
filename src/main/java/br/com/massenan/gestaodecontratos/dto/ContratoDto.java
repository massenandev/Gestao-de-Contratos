package br.com.massenan.gestaodecontratos.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.massenan.gestaodecontratos.domain.Contrato;
import br.com.massenan.gestaodecontratos.domain.Pessoa;

public class ContratoDto {

	private Long id;
	private String descricao;
	private String tipo;
	private Pessoa pessoa;
	private LocalDateTime dtCadastro;
	private LocalDateTime dtUltAlt;
	private LocalDateTime dataVigor;
	private LocalDateTime dataExpiracao;
	private LocalDateTime dataRevogacao;
	private boolean ativo;

	public static List<ContratoDto> parse(List<Contrato> contratos) {
		return null;
	}

	public static Contrato parse(ContratoDto contratoDto) {
		Contrato con = new Contrato();
		con.setId(contratoDto.getId());
		con.setDescricao(contratoDto.getDescricao());
		con.setTipo(contratoDto.getTipo());
		con.setDtCadastro(contratoDto.getDtCadastro());
		con.setDtUltAlt(contratoDto.getDtUltAlt());
		con.setDataVigor(contratoDto.getDataVigor());
		con.setDataExpiracao(contratoDto.getDataExpiracao());
		con.setDataRevogacao(contratoDto.getDataRevogacao());
		con.setAtivo(contratoDto.isAtivo());

		Pessoa pess = new Pessoa();
		pess.setId(contratoDto.getId());
		con.setPessoa(pess);
		return con;
	}

	public static ContratoDto parse(Contrato contrato) {
		ContratoDto dto = new ContratoDto();
		dto.setId(contrato.getId());
		dto.setDescricao(contrato.getDescricao());
		dto.setTipo(contrato.getTipo());
		dto.setDtCadastro(contrato.getDtCadastro());
		dto.setDtUltAlt(contrato.getDtUltAlt());
		dto.setDataVigor(contrato.getDataVigor());
		dto.setDataExpiracao(contrato.getDataExpiracao());
		dto.setDataRevogacao(contrato.getDataRevogacao());
		dto.setAtivo(contrato.isAtivo());

		Pessoa pess = new Pessoa();
		pess.setId(contrato.getId());
		dto.setPessoa(pess);
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

	public LocalDateTime getDataVigor() {
		return dataVigor;
	}

	public void setDataVigor(LocalDateTime dataVigor) {
		this.dataVigor = dataVigor;
	}

	public LocalDateTime getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(LocalDateTime dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public LocalDateTime getDataRevogacao() {
		return dataRevogacao;
	}

	public void setDataRevogacao(LocalDateTime dataRevogacao) {
		this.dataRevogacao = dataRevogacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
