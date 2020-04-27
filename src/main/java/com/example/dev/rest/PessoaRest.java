package com.example.dev.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.domain.Pessoa;
import com.example.dev.service.PessoaService;
import com.example.dev.service.dto.PessoaInfoDTO;

import javassist.NotFoundException;

@RestController
@RequestMapping("/app")
public class PessoaRest {
	@Autowired
	private PessoaService pessoa_serv;
	
	@GetMapping("/pessoa/dto-{id}")
	public ResponseEntity<PessoaInfoDTO> get_pessoa_info_dto(@PathVariable Long id){
		try {
			PessoaInfoDTO pessoaInfo = pessoa_serv.get_pessoa_info_dto(id);
			return ResponseEntity.ok(pessoaInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/pessoa")
	public ResponseEntity<Pessoa> salvar_pessoa(@RequestBody @Valid Pessoa pessoa){
		return ResponseEntity.ok(pessoa_serv.salvar_pessoa(pessoa));
	}
	
	@DeleteMapping("/pessoa/{id}")
	public ResponseEntity deletar_pessoa(@PathVariable Long id){
		try {
			pessoa_serv.pessoa_delete(id);
			return ResponseEntity.ok().build(); 
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/pessoa")
	public ResponseEntity<Pessoa> update_pessoa(@RequestBody @Valid Pessoa pessoa){
		return ResponseEntity.ok(pessoa_serv.pessoa_update(pessoa));
	}
	
	@GetMapping("/pessoa")
	public ResponseEntity<List<Pessoa>> listar_pessoas(){
		return ResponseEntity.ok(pessoa_serv.listar_pessoas());
	}
	
}
