package com.alura.alunos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alura.alunos.DAO.AlunoDAO;
import com.alura.alunos.R;
import com.alura.alunos.model.Aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class activity_tela_inicial extends AppCompatActivity {

    private final AlunoDAO dao = new AlunoDAO();
    public static final String TITLE = "Lista de Alunos";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITLE);
        setContentView(R.layout.activity_tela_inicial);
        inicializaBotao();
    }

    private void inicializaBotao() {
        FloatingActionButton botao = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_tela_inicial.this, activity_cadastro_alunos.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista(dao);
    }

    private void configuraLista(AlunoDAO dao) {
        ListView listaDeAlunos = findViewById(R.id.main_list_view);
        final List<Aluno> todosAlunos = dao.todos();
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todosAlunos));
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(activity_tela_inicial.this, "A posicao é " + i, Toast.LENGTH_SHORT).show();
                Aluno alunoClicado = todosAlunos.get(i);
                //3:27 vídeo
            }
        });

    }
}
