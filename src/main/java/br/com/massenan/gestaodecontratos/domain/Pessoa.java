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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PESSOA")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_PESSOA", nullable = false)
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "IDADE", nullable = false)
	private String idade;

	@Column(name = "CPF", nullable = false)
	private String cpf;

	@Column(name = "TEL_RESIDENCIAL", nullable = true)
	private String telResidencial;

	@Column(name = "TEL_PRINCIPAL", nullable = true)
	private String telPrincipal;

	@Column(name = "CELULAR", nullable = true)
	private String celular;

	@Column(name = "E_MAIL", nullable = true)
	private String email;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_ENDERECO", nullable = false)
	private Endereco endereco;
	
	@Column(name = "DATA_CADASTRO", nullable = false)
	private LocalDateTime dtCadastro;

	@Column(name = "DATA_ULTIMA_ALTERACAO", nullable = false)
	private LocalDateTime dtUltAlt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_USUARIO", nullable = false)
	private Usuario usuario;
	
	@Column(name = "ATIVO")
	private boolean ativo;

	//GETTERS AND SETTERS
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

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelResidencial() {
		return telResidencial;
	}

	public void setTelResidencial(String telResidencial) {
		this.telResidencial = telResidencial;
	}

	public String getTelPrincipal() {
		return telPrincipal;
	}

	public void setTelPrincipal(String telPrincipal) {
		this.telPrincipal = telPrincipal;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", telResidencial="
				+ telResidencial + ", telPrincipal=" + telPrincipal + ", celular=" + celular + ", email=" + email
				+ ", endereco=" + endereco + ", dtCadastro=" + dtCadastro + ", dtUltAlt=" + dtUltAlt + ", ativo="
				+ ativo + "]";
	}

	
}
