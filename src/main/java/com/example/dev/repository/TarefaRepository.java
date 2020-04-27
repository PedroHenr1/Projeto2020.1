package com.example.dev.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dev.domain.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	public List<Tarefa> findTarefaByDataInicialBetween(LocalDate inicio, LocalDate fim);
	public List<Tarefa> findTarefaByStatusAndDataInicialBetween(Tarefa.Status status, LocalDate inicio, LocalDate fim);
	public List<Tarefa> findTarefaBypontosTarefaBetween(Long pts_min, Long pts_max);
}
