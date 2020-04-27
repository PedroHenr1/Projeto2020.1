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

import com.example.dev.domain.Projeto;
import com.example.dev.service.ProjetoService;
import com.example.dev.service.dto.ProjetoInfoDTO;

import javassist.NotFoundException;

@RestController
@RequestMapping("/app")
public class ProjetoRest {
	@Autowired
	private ProjetoService projeto_serv;
	
	@GetMapping("/projeto/dto-{id}")
	public ResponseEntity<ProjetoInfoDTO> get_projeto_info_dto(@PathVariable Long id){
		try {
			ProjetoInfoDTO projeto = projeto_serv.get_projeto_info_dto(id);
			return ResponseEntity.ok(projeto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		

	}
	
	@PostMapping("/projeto")
	public ResponseEntity<Projeto> salvar_projeto(@RequestBody @Valid Projeto pjt){
		return ResponseEntity.ok(projeto_serv.salvar_projeto(pjt));
	}
	
	@DeleteMapping("/projeto/{id}")
	public ResponseEntity<Projeto> deletar_projeto(@PathVariable Long id){
		try {
			projeto_serv.deletar_projeto(id);
			return ResponseEntity.ok().build(); 
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/projeto")
	public ResponseEntity<Projeto> update_projeto(@RequestBody @Valid Projeto pjt){
		return ResponseEntity.ok(projeto_serv.update_projeto(pjt));
	}
	
	@GetMapping("/projeto")
	public ResponseEntity<List<Projeto>> listar_projeto(){
		return  ResponseEntity.ok(projeto_serv.listar_projetos());
	}
}
