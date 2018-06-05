package com.example.aluno.pokequizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText email;
    private EditText senha;
    private EditText ConfirmaSenha;
    private Button cadastrar;

    private AppPokequizz app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        usuario = (EditText) findViewById(R.id.usuarioCadastro);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);
        ConfirmaSenha = (EditText) findViewById(R.id.ConfirmarSenha);
        cadastrar = (Button) findViewById(R.id.BotaoCadastrar);

        app = new AppPokequizz(this);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String ret = app.cadastrar(CadastroActivity.this
                        , usuario.getText().toString()
                ,email.getText().toString(),senha.getText().toString(),ConfirmaSenha.getText().toString());

                if (ret.equals("OK")){

                    // saida
                    CadastroActivity.this.finish();
                    Toast.makeText(CadastroActivity.this, "cadastro realizado com sucesso ", Toast.LENGTH_SHORT).show();

                }else{

                    //exibir o erro
                    Toast.makeText(CadastroActivity.this, ret, Toast.LENGTH_SHORT).show();

                }
            }
        });



    }




}
