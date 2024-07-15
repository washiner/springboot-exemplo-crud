package com.washiner.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.washiner.crud.model.Empregado;

@Repository                                                 //jpa vai gerenciar essa entidade
public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{
                                                                       //tipo da chave primaria que tem nela
}

// o jpa esta incluso todas as operaçoes de crud