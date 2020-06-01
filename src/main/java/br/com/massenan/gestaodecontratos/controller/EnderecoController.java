package br.com.massenan.gestaodecontratos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.massenan.gestaodecontratos.dto.EnderecoDto;
import br.com.massenan.gestaodecontratos.service.EnderecoService;

@Controller
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(EnderecoDto.parse(enderecoService.findAll()));
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> loadById(@PathVariable Long id) {
		return ResponseEntity.ok().body(EnderecoDto.parse(enderecoService.findById(id).get()));
	}

	@PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody EnderecoDto enderecoDto) {

		try {
			enderecoService.create(EnderecoDto.parse(enderecoDto));
			return new ResponseEntity<>(EnderecoDto.parse(enderecoService.findAll()), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(EnderecoDto enderecoDto) {

		try {
			enderecoService.update(EnderecoDto.parse(enderecoDto));
			return ResponseEntity.ok("Endereço atualizado com sucesso!");
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
