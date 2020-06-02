package br.com.massenan.gestaodecontratos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/api/cidades")
public class CidadeController {
	private static final Logger logger = LoggerFactory.getLogger(CidadeController.class);

	@Autowired
	private CidadeService cidadeService;

	@GetMapping("/listar")
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok().body(CidadeDto.parse(cidadeService.findAll()));
		} catch (Exception ex) {
			logger.error("[CARREGANDO-TODAS-AS-CIDADES]", ex.fillInStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> loadById(@PathVariable Long id) {
		return ResponseEntity.ok().body(CidadeDto.parse(cidadeService.findById(id).get()));
	}

	@PostMapping("/criar")
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
