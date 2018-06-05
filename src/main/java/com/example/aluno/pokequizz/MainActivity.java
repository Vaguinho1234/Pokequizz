package com.example.aluno.pokequizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private TextView txtNome;
    private TextView txtPontos;
    private TextView txtQPokemon;
    private Button btnPular;
    private EditText edtPokebox;
    private ImageView imgPoke;
    AppPokequizz app;
    Pokemon pokemon;
    private  int pontos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = (TextView) findViewById(R.id.txtNome);
        txtPontos = (TextView) findViewById(R.id.txtPontos);
        txtQPokemon = (TextView) findViewById(R.id.txtQPokemon);
        btnPular = (Button) findViewById(R.id.btnPular);
        edtPokebox = (EditText) findViewById(R.id.edtPokebox);
        imgPoke = (ImageView) findViewById(R.id.imgPoke);
        pontos = 0;
        app = new AppPokequizz(this);

        novaJogada();

        btnPular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pontos = pontos - 5;
                novaJogada();

            }
        });

        edtPokebox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                testaJogada();

            }
        });


    }


    public void testaJogada(){

        if(pokemon.nome.toUpperCase().equals(edtPokebox.getText().toString().toUpperCase())){
            imgPoke.setImageDrawable(getResources().getDrawable(pokemon.imagem));

            Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        synchronized (this) {
                            wait(2000);



                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    pontos = pontos + 5;
                                    novaJogada();


                                }
                            });

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                    //startActivity(mainActivity);
                };
            };
            thread.start();


        }

    }

    public void novaJogada(){

        pokemon = app.pokemonAelatorio();

        txtNome.setText("");
        txtPontos.setText(String.valueOf(pontos));
        imgPoke.setImageDrawable(getResources().getDrawable(pokemon.sombra));
        edtPokebox.setText("");







        /*
        timer = new Timer();
        final int[] tempo = {0};
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tempo[0] +=1;
                txtTimer.setText( String.valueOf(tempo[0]));
            }
        },1000,5000);

*/

    }
}
