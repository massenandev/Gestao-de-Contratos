package br.com.massenan.gestaodecontratos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.massenan.gestaodecontratos.domain.PerfilEnum;
import br.com.massenan.gestaodecontratos.domain.Usuario;
import br.com.massenan.gestaodecontratos.dto.UsuarioDto;
import br.com.massenan.gestaodecontratos.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> findAll() {
		Usuario usr = new Usuario();
		usr.setAtivo(true);
		usr.setPendente(true);
		usr.setPerfil(PerfilEnum.ADMIN);
		usr.setSenha("123456");
		usr.setUsername("Leticia");
		service.create(usr);
		return ResponseEntity.ok().body(UsuarioDto.parse(service.findAll()));
	}
}
