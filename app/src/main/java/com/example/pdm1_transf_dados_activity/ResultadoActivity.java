package com.example.pdm1_transf_dados_activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvNome;

    private Bundle pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        conectarComViewport();
        receberPacote();
        apresentarNome();
    }

    private void conectarComViewport() {
        tvNome = findViewById(R.id.tv_nome);
    }

    public void apresentarNome(){
        tvNome.setText(pacote.getString("nomeDaPessoa"));
    }

    public void receberPacote(){
        Intent i = getIntent();
        pacote = i.getExtras();
    }

    public void mostrarMensagemToast(View v){
        Toast toast = Toast.makeText(
                getApplicationContext(),
                "Olá " + pacote.getString("nomeDaPessoa") + ", seja bem vindo!",
                Toast.LENGTH_LONG);
        toast.show();
    }

    public void mostrarMensagemAlertDialog(View v){
        AlertDialog alert = new AlertDialog.Builder(this).create();

        alert.setTitle("Olá " + pacote.getString("nomeDaPessoa"));
        alert.setMessage("Seja bem vindo!");
        alert.show();
    }

}