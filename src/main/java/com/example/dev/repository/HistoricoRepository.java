package com.example.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dev.domain.Historico_projeto;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico_projeto, Long>{

}
