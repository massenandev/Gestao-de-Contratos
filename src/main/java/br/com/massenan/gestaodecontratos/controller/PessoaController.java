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

import br.com.massenan.gestaodecontratos.dto.PessoaDto;
import br.com.massenan.gestaodecontratos.service.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/listar")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(PessoaDto.parse(pessoaService.findAll()));
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> loadById(@PathVariable Long id) {
		return ResponseEntity.ok().body(PessoaDto.parse(pessoaService.findById(id).get()));
	}

	@PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody PessoaDto pessoaDto) {

		try {
			pessoaService.create(PessoaDto.parse(pessoaDto));
			return new ResponseEntity<>(PessoaDto.parse(pessoaService.findAll()), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(PessoaDto pessoaDto) {

		try {
			pessoaService.update(PessoaDto.parse(pessoaDto));
			return ResponseEntity.ok("Pessoa atualizada com sucesso!");
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
