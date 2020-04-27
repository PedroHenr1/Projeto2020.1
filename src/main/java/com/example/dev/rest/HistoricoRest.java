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

import com.example.dev.domain.Historico_projeto;
import com.example.dev.service.HistoricoService;

@RestController
@RequestMapping("/app")
public class HistoricoRest {
	
	@Autowired
	private HistoricoService historico_serv;
	
	@PostMapping("/historico")
	public ResponseEntity<Historico_projeto> salvar_historico(@RequestBody @Valid Historico_projeto historico){
		return ResponseEntity.ok(historico_serv.salvar_historico(historico));
	}
	
	@DeleteMapping("/historico/{id}")
	public ResponseEntity deletar_historico(@PathVariable Long id){
		try {
			historico_serv.deletar_historico(id);;
			return ResponseEntity.ok().build(); 
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/historico")
	public ResponseEntity<Historico_projeto> update_historico(@RequestBody @Valid Historico_projeto historico){
		return ResponseEntity.ok(historico_serv.update_historico(historico));
	}
	
	@GetMapping("/historico")
	public ResponseEntity<List<Historico_projeto>> listar_historico(){
		return  ResponseEntity.ok(historico_serv.listar_historico());
	}
}
