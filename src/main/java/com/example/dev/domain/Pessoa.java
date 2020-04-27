package com.example.dev.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import com.sun.istack.Nullable;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pessoaId;
	private String nome;
	private String sobrenome;
	
	@Email
	private String email;
	
	private String telefone;
	
	@Nullable
	private LocalDate data_contratacao;
	
	@ManyToOne
	@Nullable
	private Departamento departamento;
	
	@OneToOne(mappedBy = "gerente")
	@Nullable
	private Historico_projeto gerente_hist;
	
	@OneToOne
	@Nullable
	private Projeto gerente_projeto;
	
	@ManyToOne
	@Nullable
	private Projeto membro_projeto;
	

	public Long getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getData_contratacao() {
		return data_contratacao;
	}
	public void setData_contratacao(LocalDate data_contratacao) {
		this.data_contratacao = data_contratacao;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Historico_projeto getGerente_hist() {
		return gerente_hist;
	}
	public void setGerente_hist(Historico_projeto gerente_hist) {
		this.gerente_hist = gerente_hist;
	}
	public Projeto getGerente_projeto() {
		return gerente_projeto;
	}
	public void setGerente_projeto(Projeto gerente_projeto) {
		this.gerente_projeto = gerente_projeto;
	}
	public Projeto getMembro_projeto() {
		return membro_projeto;
	}
	public void setMembro_projeto(Projeto membro_projeto) {
		this.membro_projeto = membro_projeto;
	}
	
	
	
}
