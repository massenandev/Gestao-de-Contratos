package br.com.massenan.gestaodecontratos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.massenan.gestaodecontratos.domain.Pessoa;
import br.com.massenan.gestaodecontratos.dto.PessoaDto;
import br.com.massenan.gestaodecontratos.service.PessoaService;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(PessoaDto.parse(pessoaService.findAll()));
	}

	@PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody PessoaDto pessoaDto) {
		
		try {
			pessoaService.create(Pessoa.parse(pessoaDto));
			return new ResponseEntity<>(PessoaDto.parse(pessoaDto.findAll()), HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(PessoaDto pessoaDto) {
		
		try {
			pessoaService.update(PessoaDto.parse(pessoaDto));
			return ResponseEntity.ok("Usuário atualizado com sucesso!");
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private List<Pessoa> inserts() {
		Pessoa user = null;
		List<Pessoa> lista = new ArrayList<Pessoa>();

//		pessoa = new Pessoa();
//		user.setActive(true);
//		user.setAlias("user-alias-1");
//		user.setCreateDate(LocalDateTime.now());
//		user.setEmail("user-email@xxxxuy.com.br");
//		user.setName("username-1");
//		user.setPassword("123456");
//		user.setUpdateDate(LocalDateTime.now());
//		users.add(user);
//
//		user = new User();
//		user.setActive(true);
//		user.setAlias("user-alias-2");
//		user.setCreateDate(LocalDateTime.now());
//		user.setEmail("user-email@yyy.com.br");
//		user.setName("username-2");
//		user.setPassword("123456");
//		user.setUpdateDate(LocalDateTime.now());
//		users.add(user);
//
//		user = new User();
//		user.setActive(true);
//		user.setAlias("user-alias-3");
//		user.setCreateDate(LocalDateTime.now());
//		user.setEmail("user-email@bbb.com.br");
//		user.setName("username-2");
//		user.setPassword("123456");
//		user.setUpdateDate(LocalDateTime.now());
//		users.add(user);
//
//		user = new User();
//		user.setActive(true);
//		user.setAlias("user-alias-4");
//		user.setCreateDate(LocalDateTime.now());
//		user.setEmail("user-email@aaa.com.br");
//		user.setName("username-4");
//		user.setPassword("123456");
//		user.setUpdateDate(LocalDateTime.now());
//		users.add(user);

		return lista;
	}

}
