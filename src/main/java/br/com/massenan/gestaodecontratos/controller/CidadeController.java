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

import br.com.massenan.gestaodecontratos.dto.CidadeDto;
import br.com.massenan.gestaodecontratos.service.CidadeService;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	@GetMapping("/listar")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(CidadeDto.parse(cidadeService.findAll()));
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> loadById(@PathVariable Long id) {
		return ResponseEntity.ok().body(CidadeDto.parse(cidadeService.findById(id).get()));
	}

	@PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody CidadeDto cidadeDto) {

		try {
			cidadeService.create(CidadeDto.parse(cidadeDto));
			return new ResponseEntity<>(CidadeDto.parse(cidadeService.findAll()), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(CidadeDto cidadeDto) {

		try {
			cidadeService.update(CidadeDto.parse(cidadeDto));
			return ResponseEntity.ok("Cidade atualizada com sucesso!");
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
