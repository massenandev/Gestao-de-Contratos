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

import br.com.massenan.gestaodecontratos.dto.ContratoDto;
import br.com.massenan.gestaodecontratos.service.ContratoService;

@Controller
@RequestMapping("/contratos")
public class ContratoController {

	@Autowired
	private ContratoService contratoService;

	@GetMapping("/listar")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(ContratoDto.parse(contratoService.findAll()));
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> loadById(@PathVariable Long id) {
		return ResponseEntity.ok().body(ContratoDto.parse(contratoService.findById(id).get()));
	}

	@PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody ContratoDto contratoDto) {

		try {
			contratoService.create(ContratoDto.parse(contratoDto));
			return new ResponseEntity<>(ContratoDto.parse(contratoService.findAll()), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(ContratoDto contratoDto) {

		try {
			contratoService.update(ContratoDto.parse(contratoDto));
			return ResponseEntity.ok("Contrato atualizado com sucesso!");
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
