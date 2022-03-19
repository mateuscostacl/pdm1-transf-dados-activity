package com.example.pdm1_transf_dados_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Bundle pacote = new Bundle();
    EditText etNome;
    Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conectarComViewport();

    }

    private void conectarComViewport() {
        etNome = findViewById(R.id.et_nome);
        btEnviar = findViewById(R.id.bt_enviar);
    }

    public void enviar(View v){
        empacotar();
        enviarPacote();
    }

    private void empacotar(){
        pacote.putString("nomeDaPessoa", etNome.getText().toString());
    }

    private void enviarPacote() {
        Intent i = new Intent(getApplicationContext(), ResultadoActivity.class);

        i.putExtras(pacote);
        startActivity(i);
    }
}