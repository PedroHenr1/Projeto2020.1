package com.example.dev.service.dto;

import java.util.List;

import com.example.dev.domain.Pessoa;
import com.example.dev.domain.Projeto;
import com.example.dev.domain.Tarefa;

public class ProjetoInfoDTO {
	private String pjtTitulo;
	private List<Pessoa> pjtMembros;
	private List<Tarefa> pjtTarefas;
	
	public ProjetoInfoDTO(Projeto pjt) {
		this.pjtTitulo = pjt.getTitulo();
		this.pjtMembros = pjt.getMembros();
		this.pjtTarefas = pjt.getPjt_tarefas();
	}

	public String getPjtTitulo() {
		return pjtTitulo;
	}

	public void setPjtTitulo(String pjtTitulo) {
		this.pjtTitulo = pjtTitulo;
	}

	public List<Pessoa> getPjtMembros() {
		return pjtMembros;
	}

	public void setPjtMembros(List<Pessoa> pjtMembros) {
		this.pjtMembros = pjtMembros;
	}

	public List<Tarefa> getPjtTarefas() {
		return pjtTarefas;
	}

	public void setPjtTarefas(List<Tarefa> pjtTarefas) {
		this.pjtTarefas = pjtTarefas;
	}
	
}
