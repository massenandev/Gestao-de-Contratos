package br.com.massenan.gestaodecontratos.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.massenan.gestaodecontratos.domain.Pessoa;
import br.com.massenan.gestaodecontratos.domain.Usuario;

public class PessoaDto {

	private Long id;
	private String nome;
	private String perfil;
	private String dtNascimento;
	private String cpf;
	private String telResidencial;
	private String telPrincipal;
	private String celular;
	private String email;
	private Usuario usuario;
	private boolean ativo;

	public static List<PessoaDto> parse(List<Pessoa> pessoas) {
		List<PessoaDto> lista = new ArrayList<PessoaDto>();
		pessoas.forEach(p -> lista.add(parse(p)));
		return lista;
	}

	public static Pessoa parse(PessoaDto pessoaDto) {
		Pessoa pes = new Pessoa();
		pes.setId(pessoaDto.getId());
		pes.setNome(pessoaDto.getNome());
		pes.setDtNascimento(pessoaDto.getDtNascimento());
		pes.setCpf(pessoaDto.getCpf());
		pes.setTelResidencial(pessoaDto.getTelResidencial());
		pes.setTelPrincipal(pessoaDto.getTelPrincipal());
		pes.setCelular(pessoaDto.getCelular());
		pes.setEmail(pessoaDto.getEmail());
		pes.setAtivo(pessoaDto.isAtivo());

		Usuario usr = new Usuario();
		usr.setId(pessoaDto.getId());
		pes.setUsuario(usr);
		return pes;
	}

	public static PessoaDto parse(Pessoa pessoa) {
		PessoaDto dto = new PessoaDto();
		dto.setId(pessoa.getId());
		dto.setNome(pessoa.getNome());
		dto.setDtNascimento(pessoa.getDtNascimento());
		dto.setCpf(pessoa.getCpf());
		dto.setTelResidencial(pessoa.getTelResidencial());
		dto.setTelPrincipal(pessoa.getTelPrincipal());
		dto.setCelular(pessoa.getCelular());
		dto.setEmail(pessoa.getEmail());
		dto.setAtivo(pessoa.isAtivo());

		Usuario usr = new Usuario();
		usr.setId(pessoa.getId());
		dto.setUsuario(usr);
		return dto;
	}

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

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
