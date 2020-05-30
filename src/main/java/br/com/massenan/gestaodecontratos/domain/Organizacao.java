package br.com.massenan.gestaodecontratos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ORGANIZACAO")
public class Organizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_ORGANIZACAO", nullable = false)
	private Long id;
	
	@Column(name = "NOME_FANTASIA", nullable = false)
	private String nomeFantasia;
	
	@Column(name = "NOME_REGISTRO", nullable = true)
	private String nomeRegistro;
	
	@Column(name = "CNPJ", nullable = false)
	private String cnpj;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_ENDERECO", nullable = false)
	private Endereco endereco;
	
	@Column(name = "ATIVO", nullable = false)
	private boolean ativo;
	
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
		Organizacao other = (Organizacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Organizacao [id=" + id + ", nomeFantasia=" + nomeFantasia + ", nomeRegistro=" + nomeRegistro + ", cnpj="
				+ cnpj + ", endereco=" + endereco + ", ativo=" + ativo + "]";
	}
}
