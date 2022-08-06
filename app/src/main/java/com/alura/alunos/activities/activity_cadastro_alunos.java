package com.alura.alunos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alura.alunos.DAO.AlunoDAO;
import com.alura.alunos.R;
import com.alura.alunos.model.Aluno;

public class activity_cadastro_alunos extends AppCompatActivity {
    public static final String TITLE = "Cadastro";
    final AlunoDAO dao = new AlunoDAO();
    private EditText campoNome;
    private EditText campoMail;
    private EditText campoFone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle(TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_alunos);
        InicializaCampos();
        ConfiguraBotao();

    }

    private void ConfiguraBotao() {
        Button BotaoSalvar = findViewById(R.id.activity_cadastro_alunos_salvar);
        BotaoSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Aluno alunoCriado = criaAluno(campoNome, campoMail, campoFone);
                dao.Salva(alunoCriado);
                startActivity(new Intent(activity_cadastro_alunos.this, activity_tela_inicial.class));
                finish();
            }
        });
    }

    private void InicializaCampos() {
        campoNome = findViewById(R.id.activity_cadastro_alunos_nome);
        campoMail = findViewById(R.id.activity_cadastro_alunos_email);
        campoFone = findViewById(R.id.activity_cadastro_alunos_telefone);
    }

    @NonNull
    private Aluno criaAluno(EditText campoNome, EditText campoMail, EditText campoFone) {
        String nome = campoNome.getText().toString();
        String email = campoMail.getText().toString();
        String fone = campoFone.getText().toString();

        Aluno alunoCriado = new Aluno(nome, email,fone);
        return alunoCriado;
    }
}