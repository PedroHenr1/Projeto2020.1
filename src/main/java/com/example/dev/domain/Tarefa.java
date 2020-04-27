package com.example.dev.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.Nullable;

@Entity
public class Tarefa {
	public enum Status{
		aberta,
		fechada
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tarefa_id;
	private Status status;
	@ManyToMany(mappedBy = "tarefas_projeto")
	private List<Projeto> projeto_id;
	private String titulo;
	private String descricao;
	private Long pontosTarefa;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	
	@ManyToMany(mappedBy = "pjt_tarefas")
	private List<Projeto> tarefa_pjt;
	
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Projeto> getProjeto_id() {
		return projeto_id;
	}
	public void setProjeto_id(List<Projeto> projeto_id) {
		this.projeto_id = projeto_id;
	}
	
	public Long getPontosTarefa() {
		return pontosTarefa;
	}
	public void setPontosTarefa(Long pontosTarefa) {
		this.pontosTarefa = pontosTarefa;
	}
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
	public List<Projeto> getTarefa_pjt() {
		return tarefa_pjt;
	}
	public void setTarefa_pjt(List<Projeto> tarefa_pjt) {
		this.tarefa_pjt = tarefa_pjt;
	}
	
	public Long getTarefa_id() {
		return tarefa_id;
	}
	public void setTarefa_id(Long tarefa_id) {
		this.tarefa_id = tarefa_id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
