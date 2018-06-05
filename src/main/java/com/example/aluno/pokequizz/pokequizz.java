package com.example.aluno.pokequizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pokequizz extends AppCompatActivity {

    private Button jogo;
    private Button lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokequizz);



        jogo = (Button)  findViewById(R.id.btnJogo);
        lista = (Button) findViewById(R.id.btnLista);

        jogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(pokequizz.this,MainActivity.class);

                startActivity(i);
            }
        });

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(pokequizz.this,listadepokemons.class);

                startActivity(i);
            }
        });

    }
}
