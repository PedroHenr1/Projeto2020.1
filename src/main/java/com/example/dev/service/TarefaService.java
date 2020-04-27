package com.example.dev.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.domain.Tarefa;
import com.example.dev.repository.TarefaRepository;
import com.example.dev.service.dto.TarefaInfoDto;

import javassist.NotFoundException;

@Service
public class TarefaService {
	
	@Autowired
	public TarefaRepository tarefa_rep;
	
	public TarefaInfoDto get_tarefa_info_dto(Long id) throws NotFoundException{
		Optional<Tarefa> tarefa = tarefa_rep.findById(id);
		if(tarefa.isEmpty())
			throw new NotFoundException("Tarefa não encontrada");
		return new TarefaInfoDto(tarefa.get());
	}
	
	public List<Tarefa> get_tarefa_periodo(LocalDate inicio, LocalDate fim) {
		return tarefa_rep.findTarefaByDataInicialBetween(inicio, fim);
	}
	
	public List<Tarefa> get_tarefa_periodo_aberta(LocalDate inicio, LocalDate fim) {
		Tarefa.Status status = Tarefa.Status.aberta;
		return tarefa_rep.findTarefaByStatusAndDataInicialBetween(status, inicio, fim);
	}
	
	public List<Tarefa> get_tarefa_periodo_fechada(LocalDate inicio, LocalDate fim) {
		Tarefa.Status status = Tarefa.Status.fechada;
		return tarefa_rep.findTarefaByStatusAndDataInicialBetween(status, inicio, fim);
	}
	
	public List<Tarefa> get_tarefa_intervalo_pontuacao(Long min, Long max){
		return tarefa_rep.findTarefaBypontosTarefaBetween(min, max);
	}
	
	public Tarefa salvar_tarefa(Tarefa tarefa) {
		//LocalDate data = LocalDate.now();
		//tarefa.setData_inicial(data);
		return tarefa_rep.save(tarefa);
	}
	
	public void deletar_tarefa(Long id) throws NotFoundException{
		if(!tarefa_rep.findById(id).isEmpty())
			tarefa_rep.deleteById(id);
		throw new NotFoundException("Tarefa não encontrada");
	}
	
	public Tarefa update_tarefa(Tarefa tarefa){
		if(tarefa != null)
			return tarefa_rep.save(tarefa);
		throw new RuntimeException("Tarefa não encontrada.");
	}
	
	public List<Tarefa> listar_tarefas(){
		try {
			return tarefa_rep.findAll();	
		} catch (Exception e) {
			throw new NullPointerException("tee");
		}
	}
}
