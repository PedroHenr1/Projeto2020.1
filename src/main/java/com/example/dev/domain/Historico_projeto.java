package com.example.dev.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Historico_projeto {
	@Id
	private Long historico_id;
	private LocalDate data_inicio;
	private LocalDate data_fim;
	
	@OneToOne
	private Pessoa gerente;
	
	@OneToOne
	private Departamento departamento;
	
	@OneToOne
	private Projeto projeto_id;
	

	public Long getHistorico_id() {
		return historico_id;
	}
	public void setHistorico_id(Long historico_id) {
		this.historico_id = historico_id;
	}
	public LocalDate getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}
	public LocalDate getData_fim() {
		return data_fim;
	}
	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}
	public Pessoa getGerente() {
		return gerente;
	}
	public void setGerente(Pessoa gerente) {
		this.gerente = gerente;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
