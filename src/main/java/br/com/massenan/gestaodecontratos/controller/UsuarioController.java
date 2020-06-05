package br.com.massenan.gestaodecontratos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.massenan.gestaodecontratos.domain.PerfilEnum;
import br.com.massenan.gestaodecontratos.domain.Usuario;
import br.com.massenan.gestaodecontratos.dto.UsuarioDto;
import br.com.massenan.gestaodecontratos.service.UsuarioService;

@Controller
@RequestMapping("/api/usuarios")
public class UsuarioController {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private UsuarioService service;

	@GetMapping("/listar")
	public ResponseEntity<?> findAll() {
		try {
			service.create(build());
			return ResponseEntity.ok().body(UsuarioDto.parse(service.findAll()));
		} catch (Exception ex) {
			logger.error("[CARREGANDO-TODOS-OS-USUARIOS]", ex.fillInStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Usuario build() {
		Usuario usu =  new Usuario();
		usu.setAtivo(true);
		usu.setPendente(true);
		usu.setPerfil(PerfilEnum.ADMIN);
		usu.setSenha("123456");
		usu.setUsername("Letícia");
		usu.setUsuario(null);
		return null;
	}
}
