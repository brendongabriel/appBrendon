package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonCadastro = (Button) findViewById(R.id.buttonCadastro);
        buttonCadastro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, telaRecebeNota.class);

        EditText nome = (EditText) findViewById(R.id.nome);

        Bundle params = new Bundle();

        params.putString("nome", nome.getText().toString());

        it.putExtras(params);
        startActivity(it);
    }
}