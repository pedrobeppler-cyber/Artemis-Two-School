package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.aluno;
import com.example.demo.repositories.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Long contarAlunos(){
        return alunoRepository.count();
    }
    public aluno buscarAlunos(Integer id){
        return alunoRepository.findById(id).get();
    }
    public List<aluno> listarAlunos(){
        return alunoRepository.findAll();
    }
    public Boolean deletarAlunos(Integer id){
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public aluno cadastrarAlunos(aluno aluno){
        return alunoRepository.save(aluno);
    }
    public aluno atualizarAlunos(Integer id, aluno aluno){
        aluno alunosRecuperados = buscarAlunos(id);
        if (alunosRecuperados != null) {
            alunosRecuperados.setId(id);
            if (aluno.getDataNascimento() != null) {
                alunosRecuperados.setDataNascimento(aluno.getDataNascimento());
            }
            return alunoRepository.save(alunosRecuperados);
        }
        return null;
    }

}
