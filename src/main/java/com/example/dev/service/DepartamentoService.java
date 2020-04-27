package com.example.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.domain.Departamento;
import com.example.dev.domain.Tarefa;
import com.example.dev.repository.DepartamentoRepository;
import com.example.dev.repository.TarefaRepository;
import com.example.dev.service.dto.DepartamentoInfoDTO;

import javassist.NotFoundException;

@Service
public class DepartamentoService {
	
	@Autowired
	public DepartamentoRepository departamento_rep;
	
	public DepartamentoInfoDTO get_departamento_info_dto(Long id) throws NotFoundException{
		Optional<Departamento> dpt = departamento_rep.findById(id);
		if(dpt.isEmpty())
			throw new NotFoundException("Departamento nao encontrado.");
		return new DepartamentoInfoDTO(dpt.get());
	}
	
	public Departamento salvar_departamento(Departamento dpt) {
		return departamento_rep.save(dpt);
	}
	
	public void deletar_departamento(Long id) throws NotFoundException{
		if(!departamento_rep.findById(id).isEmpty())
			departamento_rep.deleteById(id);
		throw new NotFoundException("Departamento não encontrada");
	}
	
	public Departamento update_departamento(Departamento dpt){
		if(dpt != null)
			return departamento_rep.save(dpt);
		throw new RuntimeException("Pessoa não existe");
	}
	
	public List<Departamento> listar_departamento(){
		return departamento_rep.findAll();
	}
}
