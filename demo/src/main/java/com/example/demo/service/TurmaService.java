package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.turma;
import com.example.demo.repositories.TurmaRepository;
@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    public Long contaTurma(){
        return turmaRepository.count();
    }
    public turma buscarTurma(Integer id){
        return turmaRepository.findById(id).get();
    }
    public List <turma> listarTurmas(){
        return turmaRepository.findAll();
    }
    public Boolean deletarTurma(Integer id){
        if (turmaRepository.existsById(id)) {
            turmaRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public turma cadastrartTurma(turma turma){
        return turmaRepository.save(turma);
    }

    public turma atualizarTurma(Integer id, turma turma){
        turma turmaRecuperada = buscarTurma(id);
        if (turmaRecuperada != null) {
            turmaRecuperada.setId(id);
            turmaRecuperada.setNome(turma.getNome());
            return turmaRepository.save(turmaRecuperada);
        }
    
        return null;
    }
}


