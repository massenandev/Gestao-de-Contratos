package br.com.massenan.gestaodecontratos.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.massenan.gestaodecontratos.domain.PerfilEnum;
import br.com.massenan.gestaodecontratos.domain.Usuario;

public class UsuarioDto {
	
	private Long id;
	private String perfil;
	private String usename;
	private String senha;
	private boolean pendente;
	private LocalDateTime dtCadastro;
	private LocalDateTime dtUltAlt;
	private boolean ativo;
	
	public static Usuario create(UsuarioDto dto) {
		Usuario usr = new Usuario();
		usr.setAtivo(true);
		usr.setPendente(true);
		usr.setPerfil(PerfilEnum.fromText(dto.getPerfil()));
		usr.setSenha(dto.getSenha());
		usr.setUsename(dto.getUsename());
		return usr;
	}
	
	public static List<UsuarioDto> parse(List<Usuario>usuarios){
		List<UsuarioDto>list = new ArrayList<UsuarioDto>();
		usuarios.forEach(u -> list.add(parse(u)));
		return list;
	}
	
	public static UsuarioDto parse(Usuario usuario) {
		UsuarioDto dto = new UsuarioDto();
		dto.setAtivo(usuario.isAtivo());
		dto.setDtCadastro(usuario.getDtCadastro());
		dto.setDtUltAlt(usuario.getDtUltAlt());
		dto.setId(usuario.getId());
		dto.setPendente(usuario.isPendente());
		dto.setPerfil(usuario.getPerfil().getTipo());
		dto.setUsename(usuario.getUsename());
		return dto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
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
	public boolean isPendente() {
		return pendente;
	}
	public void setPendente(boolean pendente) {
		this.pendente = pendente;
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
	
}
