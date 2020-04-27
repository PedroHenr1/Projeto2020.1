package com.example.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.domain.Projeto;
import com.example.dev.repository.ProjetoRepository;
import com.example.dev.service.dto.ProjetoInfoDTO;

import javassist.NotFoundException;

@Service
public class ProjetoService {
	
	@Autowired
	public ProjetoRepository projeto_rep;
	
	public ProjetoInfoDTO get_projeto_info_dto(Long id) throws NotFoundException {
		Optional<Projeto> projeto = projeto_rep.findById(id);
		if(projeto.isEmpty())
			throw new NotFoundException("Projeto não encontrado.");
		return new ProjetoInfoDTO(projeto.get());
	}
	
	public Projeto salvar_projeto(Projeto pjt) {
		return projeto_rep.save(pjt);
	}
	
	public void deletar_projeto(Long id) throws NotFoundException{
		if(!projeto_rep.findById(id).isEmpty())
			projeto_rep.deleteById(id);
		throw new NotFoundException("Projeto não encontrada");
	}
	
	public Projeto update_projeto(Projeto pjt){
		if(pjt != null)
			return projeto_rep.save(pjt);
		throw new RuntimeException("Projeto não encontrada.");
	}
	
	public List<Projeto> listar_projetos(){
		return projeto_rep.findAll();
	}
}
