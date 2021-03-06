package br.com.massenan.gestaodecontratos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	@GetMapping("/home/menu")
	public String home() {
		return "home";
	}
	
	@GetMapping("/pessoa/menu")
	public String pessoa() {
		return "/pessoa/pessoa";
	}

	@GetMapping("/usuario/menu")
	public String usuario() {
		return "/usuario/usuario";
	}
	
	@GetMapping("/cidade/menu")
	public String cidade() {
		return "/cidade/cidade";
	}
	
	@GetMapping("/endereco/menu")
	public String endereco() {
		return "/endereco/endereco";
	}
}
