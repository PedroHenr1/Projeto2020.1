package com.example.dev.rest;

import java.time.LocalDate;
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

import com.example.dev.domain.Tarefa;
import com.example.dev.service.TarefaService;
import com.example.dev.service.dto.TarefaInfoDto;

@RestController
@RequestMapping("/app")
public class TarefaRest {
	
	@Autowired
	private TarefaService tarefa_serv;
	
	@GetMapping("/tarefa/dto-{id}")
	public ResponseEntity<TarefaInfoDto> get_tarefa_info_dto(@PathVariable Long id){
		try {
			TarefaInfoDto tarefa = tarefa_serv.get_tarefa_info_dto(id);
			return ResponseEntity.ok(tarefa);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value = "/tarefa/{inicio}/{fim}")
	public ResponseEntity<List<Tarefa>> get_tarefa_periodo(@PathVariable String inicio, @PathVariable String fim){
		return ResponseEntity.ok(tarefa_serv.get_tarefa_periodo(LocalDate.parse(inicio), LocalDate.parse(fim)));
	}
	
	@GetMapping(value = "/tarefa/{inicio}/{fim}/aberta")
	public ResponseEntity<List<Tarefa>> get_tarefa_periodo_aberta(@PathVariable String inicio, @PathVariable String fim){  
		return ResponseEntity.ok(tarefa_serv.get_tarefa_periodo_aberta(LocalDate.parse(inicio), LocalDate.parse(fim)));
	}
	
	@GetMapping(value = "/tarefa/{inicio}/{fim}/fechada")
	public ResponseEntity<List<Tarefa>> get_tarefa_periodo_fechada(@PathVariable String inicio, @PathVariable String fim){  
		return ResponseEntity.ok(tarefa_serv.get_tarefa_periodo_fechada(LocalDate.parse(inicio), LocalDate.parse(fim)));
	}
	
	@GetMapping(value = "/tarefa/pontuacao/{min}-{max}")
	public ResponseEntity<List<Tarefa>> get_tarefa_intervalo_pontuacao(@PathVariable Long min, @PathVariable Long max){
		return ResponseEntity.ok(tarefa_serv.get_tarefa_intervalo_pontuacao(min, max));
	}
	
	@PostMapping("/tarefa")
	public ResponseEntity<Tarefa> salvar_tarefa(@RequestBody @Valid Tarefa tarefa){
		return ResponseEntity.ok(tarefa_serv.salvar_tarefa(tarefa));
	}
	
	@DeleteMapping("/tarefa/{id}")
	public ResponseEntity deletar_tarefa(@PathVariable Long id){
		try {
			tarefa_serv.deletar_tarefa(id);
			return ResponseEntity.ok().build(); 
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/tarefa")
	public ResponseEntity<Tarefa> update_tarefa(@RequestBody @Valid Tarefa tarefa){
		return ResponseEntity.ok(tarefa_serv.update_tarefa(tarefa));
	}
	
	@GetMapping("/tarefa")
	public ResponseEntity<List<Tarefa>> listar_tarefas(){
		return ResponseEntity.ok(tarefa_serv.listar_tarefas());
	}
}
