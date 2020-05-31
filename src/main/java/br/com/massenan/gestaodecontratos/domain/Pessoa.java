package br.com.massenan.gestaodecontratos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@Enumerated(EnumType.STRING)
	@Column(name="PERFIL")
	private PerfilEnum perfil;
	
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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CD_ENDERECO", nullable = false)
	private Endereco endereco;
	
	@Column(name = "ATIVO")
	private boolean ativo;
	
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
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
		return "Pessoa [id=" + id + ", nome=" + nome + ", perfil=" + perfil + ", idade=" + idade + ", cpf=" + cpf
				+ ", telResidencial=" + telResidencial + ", telPrincipal=" + telPrincipal + ", celular=" + celular
				+ ", email=" + email + ", endereco=" + endereco + ", ativo=" + ativo + "]";
	}

	public void setPerfil(String string) {
		
	}
}
