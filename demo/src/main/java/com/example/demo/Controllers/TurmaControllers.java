package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.turma;
import com.example.demo.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaControllers {
    
    @Autowired
    private TurmaService turmaService;

    @GetMapping("/contar-turma")
    public Long contarTurma(){
        return turmaService.contaTurma();
    }

    @GetMapping("/buscar-turma{id}")
    public turma buscarTurma(@PathVariable Integer id){
        return turmaService.buscarTurma(id);
    }

    @GetMapping("listar-turma")
    public List<turma> listaTurmas(){
        return turmaService.listarTurmas();
    }

    @DeleteMapping("/deletAR-turma/{id}")
    public String deletarTurma(@PathVariable Integer id){
        if (turmaService.deletarTurma(id)) {
            return "Turma excluida com sucesso";
        }
        return "Falha na exclusão da turma";
    }

    @PostMapping("salvar-turma")
    public turma cadastrarTurma(@PathVariable Integer id, @RequestBody turma turma){
        return turmaService.cadastrartTurma(turma);
    }

    public String atualizarTurma(@PathVariable Integer id, @RequestBody turma turma){
        if (turmaService.atualizarTurma(id, turma)!= null) {
            return "Turma atualizada com sucesso";
        }
        return "Falha na atualização da turma";
    }


}
