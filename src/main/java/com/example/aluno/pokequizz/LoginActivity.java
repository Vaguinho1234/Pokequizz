package com.example.aluno.pokequizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsuario;
    private EditText editTextSenha;
    private Button buttonEntrar;
    private Button loginCadastrar;

    private AppPokequizz app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextSenha = (EditText) findViewById(R.id.editTextSenha);
        buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
        loginCadastrar = (Button) findViewById(R.id.LoginCadastro);

        app = new AppPokequizz(this);





        buttonEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Boolean valido = app.login(LoginActivity.this
                        ,editTextUsuario.getText().toString()
                        ,editTextSenha.getText().toString());

                if (valido) {
                    app.testeCarregaBanco(LoginActivity.this);

                    Intent i = new Intent(LoginActivity.this, pokequizz.class);
                    startActivity(i);
                    LoginActivity.this.finish();

                }else{
                    Toast.makeText(LoginActivity.this,"Login invalido",Toast.LENGTH_SHORT).show();
                }

            }
        });


        loginCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent o = new Intent(LoginActivity.this,CadastroActivity.class);
                startActivity(o);
            }
        });

        /*
         Intent i = new Intent(SplashScreenActivity.this,LoginActivity.class);
                    startActivity(i);
*/

    }
}
