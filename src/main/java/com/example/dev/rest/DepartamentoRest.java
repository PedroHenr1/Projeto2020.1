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

import com.example.dev.domain.Departamento;
import com.example.dev.service.DepartamentoService;
import com.example.dev.service.dto.DepartamentoInfoDTO;

@RestController
@RequestMapping("/app")
public class DepartamentoRest {

	@Autowired
	private DepartamentoService departamento_serv;
	
	@GetMapping("/departamento/dto-{id}")
	public ResponseEntity<DepartamentoInfoDTO> get_departamento_info_dto(@PathVariable Long id){
		try {
			DepartamentoInfoDTO dpt = departamento_serv.get_departamento_info_dto(id);
			return ResponseEntity.ok(dpt);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/departamento")
	public ResponseEntity<Departamento> salvar_departamento(@RequestBody @Valid Departamento dpt){
		return ResponseEntity.ok(departamento_serv.salvar_departamento(dpt));
	}
	
	@DeleteMapping("/departamento")
	public ResponseEntity deletar_departamento(@PathVariable Long id){
		try {
			departamento_serv.deletar_departamento(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/departamento")
	public ResponseEntity<Departamento> update_departamento(@RequestBody @Valid Departamento dpt){
		return ResponseEntity.ok(departamento_serv.update_departamento(dpt));
	}
	
	@GetMapping("/departamento")
	public ResponseEntity<List<Departamento>> listar_departamentos(){
		return ResponseEntity.ok(departamento_serv.listar_departamento());
	}
}
