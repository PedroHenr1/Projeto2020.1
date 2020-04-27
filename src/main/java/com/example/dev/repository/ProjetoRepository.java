package com.example.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dev.domain.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

}
