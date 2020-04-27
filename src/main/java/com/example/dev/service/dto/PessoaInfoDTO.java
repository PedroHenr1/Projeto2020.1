package com.example.dev.service.dto;

import com.example.dev.domain.Pessoa;

public class PessoaInfoDTO {
	private String nome;
	private String sobreNome;
	private String email;
	private String gerente_pjt;
	
	public PessoaInfoDTO(Pessoa pessoa){
		this.nome = pessoa.getNome();
		this.sobreNome = pessoa.getSobrenome();
		this.email = pessoa.getEmail();
		try {
			this.gerente_pjt = pessoa.getGerente_projeto().getTitulo();
		} catch (Exception e) {
			this.gerente_pjt = "nenhum";
		}
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getGerente_pjt() {
		return gerente_pjt;
	}

	public void setGerente_pjt(String gerente_pjt) {
		this.gerente_pjt = gerente_pjt;
	}
	
	
	
}
