package br.com.massenan.gestaodecontratos.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CONTRATO")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_CONTRATO", nullable = false)
	private Long id;

	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO", nullable = false)
	private ContratoTipoEnum tipo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_PESSOA", nullable = false)
	private Pessoa pessoa;

	@Column(name = "DATA_CADASTRO", nullable = false)
	private LocalDateTime dtCadastro;

	@Column(name = "DATA_ULTIMA_ALTERACAO", nullable = false)
	private LocalDateTime dtUltAlt;

	@Column(name = "DATA_VIGOR", nullable = false)
	private LocalDateTime dataVigor;

	@Column(name = "DATA_EXPIRACAO", nullable = false)
	private LocalDateTime dataExpiracao;

	@Column(name = "DATA_REVOGACAO", nullable = false)
	private LocalDateTime dataRevogacao;

	@Column(name = "ATIVO", nullable = false)
	private boolean ativo;

	@PreUpdate
	public void preUpdate() {
		dtUltAlt = LocalDateTime.now();
	}

	@PrePersist
	public void prePersist() {
		dtUltAlt = LocalDateTime.now();
		dtCadastro = LocalDateTime.now();
	}

	// GETTERS AND SETTERS

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	// GETTERS AND SETTERS
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
				+ ", dtCadastro=" + dtCadastro + ", dtUltAlt=" + dtUltAlt + ", dataVigor=" + dataVigor
				+ ", dataExpiracao=" + dataExpiracao + ", dataRevogacao=" + dataRevogacao + ", ativo=" + ativo + "]";
	}

}
