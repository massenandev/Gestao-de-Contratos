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
@Table(name = "TB_USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_USUARIO", nullable = false)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="PERFIL")
	private PerfilEnum perfil;

	@Column(name = "USERNAME", nullable = false)
	private String usename;
	
	@Column(name = "SENHA", nullable = false)
	private String senha;

	@Column(name = "PENDENTE", nullable = false)
	private boolean pendente;

	@Column(name = "DATA_CADASTRO", nullable = false)
	private LocalDateTime dtCadastro;

	@Column(name = "DATA_ULTIMA_ALTERACAO", nullable = false)
	private LocalDateTime dtUltAlt;
	
	@Column(name = "ATIVO", nullable = false)
	private boolean ativo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CD_USUARIO_CADASTRO", nullable=true)
	private Usuario usuario;
	
	@PreUpdate
	public void preUpdate() {
		dtUltAlt = LocalDateTime.now();
	}

	@PrePersist
	public void prePersist() {
		dtUltAlt = LocalDateTime.now();
		dtCadastro = LocalDateTime.now();
	}
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public boolean isPendente() {
		return pendente;
	}
	public void setPendente(boolean pendente) {
		this.pendente = pendente;
	}
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", perfil=" + perfil + ", usename=" + usename + ", senha=" + senha + ", pendente="
				+ pendente + ", dtCadastro=" + dtCadastro + ", dtUltAlt=" + dtUltAlt + ", ativo=" + ativo + "]";
	}
	
	
}
