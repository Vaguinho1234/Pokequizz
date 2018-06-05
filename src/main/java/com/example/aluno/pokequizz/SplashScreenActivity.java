package com.example.aluno.pokequizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    private float rotation;
    private ImageView imagem;
    private ProgressBar barra;
    private int progresso;
    private AppPokequizz pokequizz;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        pokequizz = new AppPokequizz(this);


        Timer timer=new Timer();
        imagem = (ImageView) findViewById(R.id.imagempokemon);
        barra = (ProgressBar) findViewById(R.id.progressBar);
       progresso = 0;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                 progresso+=10;

                processaRotacao();
                barra.setProgress(progresso);

                if (progresso >=100){

                    if (pokequizz.estaLogado(SplashScreenActivity.this)){

                        Intent i = new Intent(SplashScreenActivity.this,pokequizz.class);
                        startActivity(i);

                    }
                    else{
                        Intent i = new Intent(SplashScreenActivity.this,LoginActivity.class);
                        startActivity(i);
                    }

                    this.cancel();
                    SplashScreenActivity.this.finish();

                }






            }
        },10
        ,100);

    }

    private void processaRotacao() {
        rotation += 50;

        try {
            imagem.setRotation(rotation);
        }
        catch(Exception e){

        }
        if (rotation == 360){
            rotation = 0;
        }




    }
}
