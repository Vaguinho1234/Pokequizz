package com.example.aluno.pokequizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class listadepokemons extends AppCompatActivity {

    ListView listView;
    adapterPokemon adapter;
    List <Pokemon> lista;

    AppPokequizz app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listadepokemons);

        app = new AppPokequizz(this);
        lista = app.getListaPokemon(this);

        listView = (ListView) findViewById(R.id.listview);

        adapter = new adapterPokemon(this,lista,app);

        listView.setAdapter(adapter);




    }
}
