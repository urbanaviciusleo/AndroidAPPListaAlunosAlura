package com.alura.alunos.model;

import androidx.annotation.NonNull;

public class Aluno {


    private final String nome;
    private final String fone;
    private final String email;

    public Aluno(String nome, String email, String fone) {
        this.nome = nome;
        this.email = email;
        this.fone = fone;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
