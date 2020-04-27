package com.example.dev.service.dto;

import com.example.dev.domain.Tarefa;

public class TarefaInfoDto {
	private Tarefa.Status status;
	private String titulo;
	private String descricao;
	
	public TarefaInfoDto(Tarefa tarefa) {
		this.status = tarefa.getStatus();
		this.titulo = tarefa.getTitulo();
		this.descricao = tarefa.getDescricao();
	}

	public Tarefa.Status getStatus() {
		return status;
	}

	public void setStatus(Tarefa.Status status) {
		this.status = status;
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
