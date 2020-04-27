package com.example.dev.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Projeto {
	
	@Id
	@GeneratedValue
	private Long pjt_id;
	private String titulo;
	private Long salario_min;
	private Long salario_max;
	
	@ManyToMany
	private List<Tarefa> tarefas_projeto;
	
	@OneToOne(mappedBy = "gerente_projeto")
	private Pessoa gerente;
	
	@OneToOne(mappedBy = "projeto_id")
	private Historico_projeto historico;
	
	@OneToMany(mappedBy = "membro_projeto")
	private List<Pessoa> membros;
	
	@ManyToMany
	private List<Tarefa> pjt_tarefas;
	
	public Long getPjt_id() {
		return pjt_id;
	}
	public void setPjt_id(Long pjt_id) {
		this.pjt_id = pjt_id;
	}
	public List<Pessoa> getMembros() {
		return membros;
	}
	public void setMembros(List<Pessoa> membros) {
		this.membros = membros;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Pessoa getGerente() {
		return gerente;
	}
	public void setGerente(Pessoa gerente) {
		this.gerente = gerente;
	}
	public Long getSalario_min() {
		return salario_min;
	}
	public void setSalario_min(Long salario_min) {
		this.salario_min = salario_min;
	}
	public Long getSalario_max() {
		return salario_max;
	}
	public void setSalario_max(Long salario_max) {
		this.salario_max = salario_max;
	}
	public Historico_projeto getHistorico() {
		return historico;
	}
	public void setHistorico(Historico_projeto historico) {
		this.historico = historico;
	}
	public List<Tarefa> getPjt_tarefas() {
		return pjt_tarefas;
	}
	public void setPjt_tarefas(List<Tarefa> pjt_tarefas) {
		this.pjt_tarefas = pjt_tarefas;
	}
	
}
