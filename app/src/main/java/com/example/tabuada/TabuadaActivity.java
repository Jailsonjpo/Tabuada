package com.example.tabuada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TabuadaActivity extends AppCompatActivity {

    private TextView titulo;
    private TextView textResultadoTabuada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabuada);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Escolher nova Tabuada");     //Titulo para ser exibido na sua Action Bar em frente à seta
        textResultadoTabuada = findViewById(R.id.textResultadoTabuada);
        titulo = findViewById(R.id.titulo);

        tabuada();


    }

    public void tabuada(){
        Bundle dados =  getIntent().getExtras();
        int tabu = dados.getInt("tabuada");
       // tabuada = Integer.parseInt(tabuada.getText().toString());

        String aux = "";

        for (int cont=1; cont<=10; cont++){
            aux=aux + tabu + " X " + cont + " = " + (tabu*cont) + "\n";
        }
        textResultadoTabuada.setText(aux);
        titulo.setText("Tabuada do: " + tabu);
    }
}
