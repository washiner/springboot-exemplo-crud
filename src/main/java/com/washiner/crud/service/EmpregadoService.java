package com.washiner.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washiner.crud.model.Empregado;
import com.washiner.crud.repository.EmpregadoRepository;

@Service
public class EmpregadoService {

    @Autowired // quer dizer automatize a execucao dessa interface que aplica JPA na tabela
               // empregado
    private EmpregadoRepository empregadoRepository; //no servico injetei o repositorio 

    public List<Empregado> getAllEmpregados() {
        return empregadoRepository.findAll();
    }

    public Optional<Empregado> getEmpregadoById(Long matricula) {
        return empregadoRepository.findById(matricula);
    }

    public Empregado saveEmpregado(Empregado empregado) {
        return empregadoRepository.save(empregado);
    }

    public void deleteEmpregado(Long mattricula) {
        empregadoRepository.deleteById(mattricula);
    }

}

// ou seja criar os meus metodos que consomem os deles do EmpregadoRepository
// agente pode fazer tudo que agente pode fazer no banco
// view tudo