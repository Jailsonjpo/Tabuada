package com.example.tabuada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class JogoActivity extends AppCompatActivity {


    private Button buttonResposta1;
    private Button buttonResposta2;
    private Button buttonResposta3;
    private Button buttonResposta4;
    private TextView textPergunta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        buttonResposta1 = (Button) findViewById(R.id.buttonResposta1);
        buttonResposta2 = (Button) findViewById(R.id.buttonResposta2);
        buttonResposta3 = (Button) findViewById(R.id.buttonResposta3);
        buttonResposta4 = (Button) findViewById(R.id.buttonResposta4);
        textPergunta = findViewById(R.id.textPergunta);

        pergunta();
    }

    public void pergunta(){

        Random r = new Random();
/*
        int num1 = 0;
        int num2 = 0;*/
        int min = 1;
        int max = 10;

        int num1 = r.nextInt((max - min)+ 1) + min;
        int num2 = r.nextInt((max - min)+ 1) + min;

        textPergunta.setText(num1 + " X " + num2);
        resposta(num1,num2);
    }

    public void resposta(int num1, int num2){

        Random r2 = new Random();

        int min = 1;
        int max = 100;

        int resp1 = r2.nextInt((max - min)+1)+min;
        int resp2 = r2.nextInt((max - min)+1)+min;
        int resp3 = r2.nextInt((max - min)+1)+min;
        int resp4 = num1*num2;

        int numero = new Random().nextInt(4);

       // for()

        //for (int cont=1; cont<=4; cont++){
       //     aux=aux + tabu + " X " + cont + " = " + (tabu*cont) + "\n";
        //}

        int[] opcoes = {resp1, resp2, resp3, resp4};
        int opcaoApp = opcoes[numero];

        buttonResposta1.setText(String.valueOf(resp4));
        buttonResposta2.setText(String.valueOf(resp1));
        buttonResposta3.setText(String.valueOf(resp2));
        buttonResposta4.setText(String.valueOf(resp3));

    }
}
