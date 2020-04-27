package com.example.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.domain.Historico_projeto;
import com.example.dev.repository.HistoricoRepository;

import javassist.NotFoundException;

@Service
public class HistoricoService {
	
	@Autowired
	public HistoricoRepository historico_rep;
	
	public Historico_projeto salvar_historico(Historico_projeto historico) {
		return historico_rep.save(historico);
	}
	
	public void deletar_historico(Long id) throws NotFoundException{
		if(!historico_rep.findById(id).isEmpty())
			historico_rep.deleteById(id);
		throw new NotFoundException("Historico não encontrada");
	}
	
	public Historico_projeto update_historico(Historico_projeto historico){
		if(historico != null)
			return historico_rep.save(historico);
		throw new RuntimeException("Historico não encontrada.");
	}
	
	public List<Historico_projeto> listar_historico(){
		return historico_rep.findAll();
	}
}
