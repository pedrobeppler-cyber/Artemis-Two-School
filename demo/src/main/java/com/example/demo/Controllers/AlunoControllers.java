package com.example.demo.Controllers;

import com.example.demo.service.AlunoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.aluno;

@RestController
@RequestMapping("/aluno")
public class AlunoControllers {
    
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/contar-alunos")
    public Long contarAlunos(){
        return alunoService.contarAlunos();
    }

    @GetMapping("/buscar-pautas/{id}")
    public aluno buscarAlunos(@PathVariable Integer id){
        return alunoService.buscarAlunos(id);
    }

    @GetMapping("/listar-alunos")
    public List<aluno> listarAlunos(){
        return alunoService.listarAlunos();
    }

    @DeleteMapping("/deletar-alunos{id}")
    public String deletarAlunos(@PathVariable Integer id){
        if (alunoService.deletarAlunos(id)) {
            return "Aluno excluido com secesso";
        }
        return "Falha na exclusão do aluno";

    }

     @PostMapping("/salvar-pauta")
    public aluno cadastrarAluno(@RequestBody aluno aluno){
        return alunoService.cadastrarAlunos(aluno);
    }

    @PutMapping("/atualizar-alunos/{id}")
    public String atualizarAluno(@PathVariable Integer id, @RequestBody aluno aluno){
        if (alunoService.atualizarAlunos(id, aluno)!= null) {
            return "Aluno atualizado com sucesso";
        }
        return "Falha na atualização do aluno";

    }



    
}
