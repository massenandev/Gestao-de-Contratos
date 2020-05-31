package br.com.massenan.gestaodecontratos.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CONTRATO_MODELO")
public class ContratoModelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_CONTRATO_MODELO", nullable = false)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO", nullable = false)
	private ContratoTipoEnum tipo;

	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	@Column(name = "DATA_CADASTRO", nullable = false)
	private LocalDateTime dtCadastro;

	@Column(name = "DATA_ULTIMA_ALTERACAO", nullable = false)
	private LocalDateTime dtUltAlt;

	@ManyToOne
	@JoinColumn(name = "CD_PESSOA", nullable = false)
	private Pessoa pessoa;

	@Column(name = "ATIVO")
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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
