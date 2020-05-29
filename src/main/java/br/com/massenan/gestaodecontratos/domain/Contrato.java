package br.com.massenan.gestaodecontratos.domain;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class Contrato {
	
	private Long id;
	private String descricao;
	private ContratoTipoEnum tipo;
	private Pessoa pessoa;
	private LocalDateTime dtCadastro;
	private LocalDateTime dtUltAlt;
	private LocalDateTime dataVigor;
	private LocalDateTime dataExpiracao;
	private LocalDateTime dataRevogacao;
	private boolean ativo;
	
	@PreUpdate
    public void preUpdate() {
		dtUltAlt = LocalDateTime.now();
    }
     
    @PrePersist
    public void prePersist() {
    	dtUltAlt =   LocalDateTime.now();
    	dtCadastro = LocalDateTime.now();
    }
	
	//GETTERS AND SETTERS
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
	public ContratoTipoEnum getTipo() {
		return tipo;
	}
	public void setTipo(ContratoTipoEnum tipo) {
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
	public LocalDateTime getDataVigor() {
		return dataVigor;
	}
	public void setDataVigor(LocalDateTime dataVigor) {
		this.dataVigor = dataVigor;
	}
	public LocalDateTime getDtUltAlt() {
		return dtUltAlt;
	}
	public void setDtUltAlt(LocalDateTime dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
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
		Contrato other = (Contrato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Contrato [id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + ", pessoa=" + pessoa
				+ ", dtCadastro=" + dtCadastro + ", dtUltAlt=" + dtUltAlt + ", dataExpiracao=" + dataExpiracao
				+ ", dataRevogacao=" + dataRevogacao + ", ativo=" + ativo + "]";
	}
	
}
