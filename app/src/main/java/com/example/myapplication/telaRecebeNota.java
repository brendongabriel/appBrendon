package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class telaRecebeNota extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_recebe_nota);

        TextView txtNome = (TextView) findViewById(R.id.nomeRecebeNota);
        Intent it = getIntent();

        if (it != null) {
            Bundle params = it.getExtras();
            if (params != null) {
                txtNome.setText(params.getString("nome"));

            }
        }


        Button buttonCadastro = (Button) findViewById(R.id.calcularMedia);
        buttonCadastro.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent it = new Intent(this, telaMedia.class);

        EditText nota4 = (EditText) findViewById(R.id.pNota);
        EditText nota3 = (EditText) findViewById(R.id.sNota);
        EditText nota2 = (EditText) findViewById(R.id.tNota);
        EditText nota1 = (EditText) findViewById(R.id.qNota);

        Bundle params = new Bundle();

        double converterNota4 = Double.parseDouble(nota4.getText().toString());
        double converterNota3 = Double.parseDouble(nota3.getText().toString());
        double converterNota2 = Double.parseDouble(nota2.getText().toString());
        double converterNota1 = Double.parseDouble(nota1.getText().toString());

        double media = (converterNota1 + converterNota2 + converterNota3 + converterNota4) / 4;

        params.putDouble("media", media);

        it.putExtras(params);
        startActivity(it);


    }
}