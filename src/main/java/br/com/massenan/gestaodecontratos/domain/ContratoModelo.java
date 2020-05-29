package br.com.massenan.gestaodecontratos.domain;

import java.time.LocalDateTime;

public class ContratoModelo {
	
	private Long id;
	private ContratoTipoEnum tipo;
	private String descricao;
	private LocalDateTime dtCadastro;
	private LocalDateTime dtUltAlt;
	private Pessoa pessoa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ContratoTipoEnum getTipo() {
		return tipo;
	}
	public void setTipo(ContratoTipoEnum tipo) {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContratoModelo other = (ContratoModelo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ContratoModelo [id=" + id + ", tipo=" + tipo + ", descricao=" + descricao + ", dtCadastro=" + dtCadastro
				+ ", dtUltAlt=" + dtUltAlt + ", pessoa=" + pessoa + "]";
	}
	
}
