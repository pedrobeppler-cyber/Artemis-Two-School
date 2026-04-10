package com.example.demo.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "usuario")
public class turma {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "aluno")
    private List<aluno> aluno;

    public turma() {
    }

    public turma(Integer id, String nome, List<com.example.demo.models.aluno> aluno) {
        this.id = id;
        this.nome = nome;
        this.aluno = aluno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<aluno> getAluno() {
        return aluno;
    }

    public void setAluno(List<aluno> aluno) {
        this.aluno = aluno;
    }

    
    
}
