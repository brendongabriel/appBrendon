package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class telaMedia extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_media);

        TextView txtMsg = (TextView) findViewById(R.id.txtMsg);
        TextView txtMedia = (TextView) findViewById(R.id.nota);
        TextView status = (TextView) findViewById(R.id.status);
        Intent it = getIntent();
        if (it != null) {
            Bundle params = it.getExtras();
            if (params != null) {
                txtMsg.setText(params.getString("nome"));
                double teste = params.getDouble("media");
                String deuBoa = Double.toString(teste);
                txtMedia.setText(deuBoa);
                if (teste > 7) {
                    status.setText("APROVADO");
                } else {
                    status.setText("REPROVADO");
                }
            }
        }

        Button buttonCadastro = (Button) findViewById(R.id.button);
        buttonCadastro.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}