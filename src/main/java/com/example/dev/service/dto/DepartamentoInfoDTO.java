package com.example.dev.service.dto;

import java.util.List;

import com.example.dev.domain.Departamento;
import com.example.dev.domain.Pessoa;

public class DepartamentoInfoDTO {
	private String dptNome;
	private List<Pessoa> dptMembros;
	public DepartamentoInfoDTO(Departamento dpt) {
		this.dptNome = dpt.getDepartamento_nome();
		this.dptMembros = dpt.getMembros();
	}
	
	public String getDptNome() {
		return dptNome;
	}
	public void setDptNome(String dptNome) {
		this.dptNome = dptNome;
	}
	public List<Pessoa> getDptMembros() {
		return dptMembros;
	}
	public void setDptMembros(List<Pessoa> dptMembros) {
		this.dptMembros = dptMembros;
	}
	
	
}
