package com.example.dev.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.domain.Pessoa;
import com.example.dev.domain.Projeto;
import com.example.dev.repository.PessoaRepository;
import com.example.dev.service.dto.PessoaInfoDTO;

import javassist.NotFoundException;

@Service
public class PessoaService {
	@Autowired
	public PessoaRepository pessoa_rep;
	
	public PessoaInfoDTO get_pessoa_info_dto(Long id) throws NotFoundException{
		Optional<Pessoa> pessoa = pessoa_rep.findById(id);
		if(pessoa != null)
			return new PessoaInfoDTO(pessoa.get());
		throw new NotFoundException("Pessoa não encontrada");
	}
	
	public Pessoa salvar_pessoa(Pessoa pessoa) {
		return pessoa_rep.save(pessoa);
	}
	
	public void pessoa_delete(Long id) throws NotFoundException{
		if(!pessoa_rep.findById(id).isEmpty())
			pessoa_rep.deleteById(id);
		throw new NotFoundException("Pessoa não encontrada");
	}
	
	public Pessoa pessoa_update(Pessoa pessoa){
		if(pessoa != null)
			return pessoa_rep.save(pessoa);
		throw new RuntimeException("Pessoa não existe");
	}
	
	public List<Pessoa> listar_pessoas(){
		return pessoa_rep.findAll();
	}
}
