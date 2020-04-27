package com.example.dev.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String departamento_nome;
	
	@OneToMany(mappedBy = "departamento")
	private List<Pessoa> membros;
	
	@OneToOne(mappedBy = "departamento")
	private Historico_projeto historico_projeto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartamento_nome() {
		return departamento_nome;
	}

	public void setDepartamento_nome(String departamento_nome) {
		this.departamento_nome = departamento_nome;
	}

	public List<Pessoa> getMembros() {
		return membros;
	}

	public void setMembros(List<Pessoa> membros) {
		this.membros = membros;
	}

	public Historico_projeto getHistorico_projeto() {
		return historico_projeto;
	}

	public void setHistorico_projeto(Historico_projeto historico_projeto) {
		this.historico_projeto = historico_projeto;
	}
	
	
}
